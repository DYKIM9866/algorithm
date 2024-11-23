package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 파티
 * 골드 3
 */
public class No1238 {
    static class  Edge{
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
        int x = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Edge(e, w));
        }

        int[] back = dijkstra(graph, x-1, n);
        int[] go = new int[n];
        for (int i = 0; i < n; i++) {
            if(i == x-1) continue;
            int[] temp = dijkstra(graph, i, n);
            go[i] = temp[x-1];
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, go[i] + back[i]);
        }

        System.out.println(answer);
    }

    private static int[] dijkstra(List<List<Edge>> graph, int start, int n) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] dist = new int[n];

        pq.offer(new Edge(start, 0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (current.weight > dist[current.target]) continue;

            for (Edge edge : graph.get(current.target)) {
                int t = edge.target;
                int w = edge.weight;
                if(dist[current.target] + w < dist[t]){
                    dist[t] = dist[current.target] + w;
                    pq.offer(new Edge(t, dist[t]));
                }
            }
        }
        return dist;
    }
}
