package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 특정 거리의 도시 찾기
 * 실버 2
 * 문제 해석
 * 1. 입력으로 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
 * 2. 도시가 연결되어 있는 M개의 도로도 주어진다.
 * 3. X에서 출발하여 최소거리가 K만큼 움직여서 도착할 수 있는 도시를 출력해라
 *
 * 풀이
 * 1. List배열을 사용하여 이어진 도시들을 담는다.
 * 2. bfs에서는 큐에 담아가면서 현재도시에서 다른 도시까지의 최소거리를 담아간다.
 * 3. 전체를 한번 돌면서 최소 거리가 K인 값을 StringBuilder에 담아 출력한다.
 */
public class No18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //도시의 개수, 도로의 개수, 원하는 거리, 출발 도시 번호
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] roads = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            roads[i] = new ArrayList<>();
        }

        //길 담기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            roads[start].add(end);
        }
        int[] shortestDis = bfs(n, x, roads);

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < n+1 ; i++) {
            if(shortestDis[i] == k){
                answer.append(i).append("\n");
            }
        }
        if(answer.length() == 0) System.out.println(-1);
        else System.out.println(answer);
    }

    private static int[] bfs(int n, int x, List<Integer>[] roads) {
        int[] shortestDis = new int[n+1];
        Deque<int[]> que = new ArrayDeque<>();
        //출발도시 설정
        shortestDis[x] = -1;
        que.offer(new int[]{x, 0});

        while (!que.isEmpty()) {
            int[] current = que.poll();

            for(int city : roads[current[0]]){
                if(shortestDis[city] != 0) continue;
                shortestDis[city] = current[1]+1;
                que.offer(new int[]{city, current[1]+1});
            }
        }

        return shortestDis;
    }
}
