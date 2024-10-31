package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 웜홀
 * 골드 3
 *
 * 문제 해석
 * 1. N개의 지점이 있고 N개의 지점사이에는 M개의 도로와 W개의 웜홀이 있다.
 * 2. M개의 도로를 지나갈 때는 시간이 소요(+)되고 W 웜홀을 통과할 때는 시간 되감기(-)가 된다.
 * 3. 시간여행을 해서 출발 위치로 도달하였을 때 시간이 되돌아가 있는 경우가 있는지 확인해라
 * 4. 첫째 줄에 테스트 케이스가 주어진다. 두번째 줄에는  N, M, W 개수가 주어지고 밑으로 M의 정보 W의 정보가 주어진다.
 * 5. 테스트 케이스마다 시간이 되돌아가는 경우가 있는지 확인하여 YES or NO를 출력해라
 * 문제 풀이
 * 1. 지점과 도로가 주어지고 음의 가중치를 갖는 것(웜홀)도 있기 때문에 벨만포드 알고리즘을 사용해야겠다고 생각했다.
 * 2. 출발 지점과 도착 지점 그리고 가중치를 담기 위해 graph를 List<int[]> 에 담아준다.
 * 3. 도로를 담고 웜홀 담는다.
 * 4. 출발지가 정해져있지 않기 때문에 각 지점마다 벨만포드를 돌리는 작업을 하려고 했다.
 *     - 코드는 맞는다고 생각했지만 91%에서 시간초과가 발생한다.
 *     - 제한시간동안 고민하다 다른 풀이를 봤다.
 *     - 이전 코드에서 보통의 벨만포드 알고리즘에서 그러하듯 거리배열을 최대 값으로 초기화한다.
 *     - 그 후에 최단거리를 초기화할 때 최댓값이 아닐 때(방문한 흔적이 있을 때)만 값을 변경한다.
 *     - 이렇게 되면 a가 다른 지점으로 가는 길이 없다면 다른 곳을 방문을 할 수가 없다.
 *     - 이문제는 최단거리를 구하는 것이 아니라 음의 사이클이 존재하는지만 알면 된다.
 * 5. 한 번만 돌려서 음의 사이클이 존재하는지 확인한다.
 * 6. 이렇게 구현된 알고리즘은 명확한 벨만포드 알고리즘은 아니다.
 */
public class No1865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            List<int[]> graph = new ArrayList<>();
            //도로 담기
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;
                int t = Integer.parseInt(st.nextToken());

                graph.add(new int[]{s, e, t});
                graph.add(new int[]{e, s, t});
            }
            //웜홀 담기
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken())-1;
                int e = Integer.parseInt(st.nextToken())-1;
                int t = Integer.parseInt(st.nextToken());

                graph.add(new int[]{s, e, -t});
            }


            if(bellmanFord(graph, n)){
                answer.append("YES");
            }else{
                answer.append("NO");
            }

            answer.append("\n");
        }

        System.out.println(answer);
    }

    private static boolean bellmanFord(List<int[]> graph, int n) {
        //거리 배열
        int[] dist = new int[n];
        Arrays.fill(dist, 10001);
        dist[0] = 0;

        for (int i = 0; i < n - 1; i++) {
            for(int[] edge : graph){
                if(dist[edge[1]] > dist[edge[0]] + edge[2]){
                    dist[edge[1]] = dist[edge[0]] + edge[2];
                }
            }
        }

        for(int[] edge : graph){
            if(dist[edge[0]] != 10001
                    && dist[edge[1]] > dist[edge[0]] + edge[2]){
                return true;
            }
        }

        return false;
    }
}
