package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 치킨 배달
 * 골드 5
 * 문제 해석
 * 1. 크기가 NxN인 도시에 집과 치킨집의 위치가 입력으로 주어진다.
 * 2. 치킨집의 매출을 위해서 M개만 남기고 모두 폐업시키려고 한다.
 * 3. 각 집에서 치킨집과의 거리가 가장 짧을 경우를 찾아라
 *
 * 문제 풀이
 * 1. 빈칸을 받을 필요 없이 집과 치킨집의 위치를 담는다.
 * 2. 각 집과 치킨집과의 거리를 담는다 (생략가능)
 * 3. 치킨집 M개를 선택하는 로직을 dfs로 구현한다.
 * 4. 치킨집을 M개 다 골랐을 때 거리가 최소가 되는 경우를 찾는다. ( 2번을 생략한 경우 이때 계산해 주어야 한다.)
 */
public class No15686 {
    static int n, m;
    static List<int[]> houses;
    static List<int[]> chickens;
    static boolean[] selected;
    static int answer = Integer.MAX_VALUE;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickens = new ArrayList<>();

        //집, 치킨집 담기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int info = Integer.parseInt(st.nextToken());
                if(info == 1){
                    houses.add(new int[]{i, j});
                }else if(info == 2){
                    chickens.add(new int[]{i, j});
                }
            }
        }

        //각 집에서 각 치킨집까지의 거리 담기
        distance = new int[houses.size()][chickens.size()];

        for (int i = 0; i < houses.size(); i++) {
            int[] house = houses.get(i);
            for (int j = 0; j < chickens.size(); j++) {
                int[] chicken = chickens.get(j);
                distance[i][j] = Math.abs(house[0] - chicken[0])
                        + Math.abs(house[1] - chicken[1]);
            }
        }

        selected = new boolean[chickens.size()];

        //치킨집 찾기
        chickenDistance(0, 0);

        System.out.println(answer);
    }

    private static void chickenDistance(int selectCnt, int start) {
        //다 찾았을 때
        if(selectCnt == m){
            int dis = 0;
            for (int i = 0; i < houses.size(); i++) {
                int temp = Integer.MAX_VALUE;
                for (int j = 0; j < chickens.size(); j++) {
                    if (selected[j]) {
                        //거리 계산 하지 않았으면 여기서 찾아줘야 함
                        temp = Math.min(temp, distance[i][j]);
                    }
                }
                dis += temp;
            }
            answer = Math.min(answer, dis);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if(selected[i]) continue;
            selected[i] = true;
            chickenDistance(selectCnt + 1, i+1);
            selected[i] = false;
        }
    }
}
