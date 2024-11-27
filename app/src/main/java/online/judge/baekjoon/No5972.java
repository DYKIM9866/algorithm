package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 택배 배송
 * 골드 5
 *
 * 문제 해석
 * 1. 현서는 찬홍이에게 택배 배달을 가야함
 * 2. 가는 길마다 소가 있어서 안전하게 지나가려면 여물을 줘야 함
 * 3. 현서는 최단거리로 가는거 보다 차라리 고생하고 여물을 조금 주는 것을 선택하고싶음
 * 4. 현서는 1번 찬홍이는 N에 있음
 * 5. 첫째줄에 N, M이 주어진다. N은 헛간, M은 길의 수
 * 6. 밑으로 M줄은 양방향 길을 소에게 줘야하는 여물의 수 까지 포함해서 주어짐 A(헛간) B(헛간) C(소여물)
 * 7. 1번 부터 N으로 갈 때 여물을 가장 적게 줄 수 있는 경우를 구해라!
 *
 * 문제 풀이
 * 1. 기본적인 다익스트라 풀이로 쉽게 풀이가능
 * 2. 양 방향으로 길 담아준다.
 * 3. 우선순위 큐를 weight 기준으로 정렬한다.
 * 4. 초기값으로 출발 edge를 넣어주고 dist배열은 출발지를 제외한 헛간을 Integer 최대값으로 설정한다.
 * 5. 현재위치의 거리가 weight 보다 작다면 넘어간다.
 * 6. 현재의 위치에서 연결된 곳을 확인하면서 업데이트 할 곳을 찾고 찾는다면 큐에 넣어준다.,
 * 7. 로직을 반복한다.
 */
public class No5972 {

    static class Edge{
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            //양방향
            graph.get(s).add(new Edge(e, w));
            graph.get(e).add(new Edge(s, w));
        }

        int[] dist = dijkstra(graph, n);

        System.out.println(dist[n - 1]);
    }

    private static int[] dijkstra(List<List<Edge>> graph, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[n];

        //초기값
        pq.offer(new Edge(0,0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if(cur.weight > dist[cur.target]) continue;

            for (Edge edge : graph.get(cur.target)) {
                int t = edge.target;
                int w = edge.weight;
                if(dist[cur.target] + w < dist[t]){
                    dist[t] = dist[cur.target] + w;
                    pq.offer(new Edge(t, dist[t]));
                }
            }
        }

        return dist;
    }
}
