package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 지름길
 * 실버 1
 *
 * 문제 해석
 * 1. 세준이는 0에서 출발해서 목표지점까지 운전해서 가야 한다.
 * 2. 가는 길 중간마다 지름길이 존재한다.
 * 3. 역주행은 없기 때문에 도착지점이 시작지점보다 낮을 수는 없다.
 * 4. 가장 적게 운전하는 경우 거리를 적어라
 *
 * 문제 풀이
 * 1. 다익스트라로 풀이
 * 2. 하지만 정형화된 다익스트라 풀이가 아니고 전체 길이에 대해서 해야 한다.
 * 3. 고속도로 전체를 노드라고 생각하고 graph와 dist 또한 고속도로 최대 길이까지 만들어줘야 한다. 그 이유는
 *     - 출발지점과 도착지점이 가야 하는 곳 위일 수도 있다.
 * 4. 재귀를 사용해서 0부터 출발하여 도착지점까지 가면서 다익스트라를 실시한다.
 */
public class No1446 {

    static class  Edge{
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    static int d;
    static List<List<Edge>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= 10000; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, w));
        }

        dist = new int[10001];
        for (int i = 0; i <= 10000; i++) {
            dist[i] = i;
        }

        dijkstra(0);

        System.out.println(dist[d]);
    }

    private static void dijkstra(int start) {
        if(start > d) return;

        //이전 값에서 하나 위
        if(dist[start+1] > dist[start] + 1){
            dist[start + 1] = dist[start] + 1;
        }

        //더 작은 값 갱신
        for(Edge edge : graph.get(start)){
            int t = edge.target;
            int w = edge.weight;
            if(dist[start] + w < dist[t]){
                dist[t] = dist[start] + w;
            }
        }

        dijkstra(start + 1);
    }
}
