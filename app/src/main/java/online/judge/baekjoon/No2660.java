package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 회장뽑기
 * 골드 5
 * 문제 해석
 * 1. 모임에서 회장선출을 하려고 하는데 조건이 있다.
 * 2. 아직 서로 모르는 사이가 존재하는데 다리를 건너면 모두가 알 수 있다.
 * 3. 가까운 정도에 따라 점수가 나뉘게 되는데 기준은 아래와 같다.
 * 4. 모두와 친구라면 1점, 한다리 건너야하는 친구가있다면 2점....
 * 5. 점수가 가장 작은 사람이 회장 후보가 된다.
 * 6. 입력으로 회원의 수와 친구관계가 주어진다.
 * 7. 출력으로 후보의 점수와 몇명인지, 누구누구 인지를 내보낸다.
 *
 * 문제 풀이
 * 1. 회원의 수가 50이하고 다리를 건너서 안다는 조건 등이 있어 플로이드-워셜을 사용한다.
 * 2. 알고리즘 안에 조건은 이어지는데 원래 값이 없다면 이어지는 값을 그대로 넣고
 * 3. 아니라면 있는 값과 이어지는 값을 더해서 넣는다.
 * 4. 회장 후보들을 담을 리스트와 가장 작아서 후보가 될 수 있는 값을 저장할 변수를 선언하고
 * 5. 각 회원들이 몇점인지 확인 후에 값을 넣는다.
 * 6. StringBuilder에 담아 출력
 */
public class No2660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x == -1 && y == -1) break;
            graph[x-1][y-1] = 1;
            graph[y-1][x-1] = 1;
        }

        //플로이드-워셜
        for (int k = 0; k < n; k++) {   // 거치기
            for (int i = 0; i < n; i++) {   //출발
                for (int j = 0; j < n; j++) {   //도착
                    if(i==j) continue;
                    if(graph[i][k] !=0 && graph[k][j] != 0){
                        if(graph[i][j] == 0){
                            graph[i][j] = graph[i][k] + graph[k][j];
                        }else{
                            graph[i][j] = Math.min(graph[i][j],
                                    graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder(); //정답 객체
        int minValue = Integer.MAX_VALUE;           //작은 값은 몇
        List<Integer> minValueCnt = new ArrayList<>(); //작은 값을 가지고 있는 개수
        for (int i = 0; i < n; i++) {
            int lineMax = 0;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                lineMax = Math.max(lineMax, graph[i][j]);
            }

            if(minValue == lineMax){
                minValueCnt.add(i+1);
            }else if(minValue > lineMax){
                minValueCnt.clear();
                minValue = lineMax;
                minValueCnt.add(i+1);
            }
        }

        answer.append(minValue)
                .append(' ')
                .append(minValueCnt.size()).append("\n");

        for(int candi : minValueCnt){
            answer.append(candi).append(' ');
        }

        System.out.println(answer);
    }
}
