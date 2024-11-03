package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 노드사이의 거리
 * 골드 5
 *
 * 문제 해석
 * 1. N개의 노드가 트리 형태로 주어진다.
 * 2. M개의 노드 간의 관계가 주어진다.
 * 3. 그 뒤로 입력되는 노드 쌍 간의 거리를 구하라
 *
 * 문제 풀이
 * 1. 출발 노드에서 각 노드의 거리를 구하면 된다.
 * 2. 음의 값도 존재하지 않고 N도 충분히 크다는 판단하에 다익스트라 사용
 * 3. 방향이 없는 노드이므로 양쪽으로 저장
 * 4. distance 배열을 선언하여 노드에서 각 노드까지의 거리를 저장한다.
 * 5. 만약에 저장된 배열이 없을 경우만 알고리즘을 사용한다.
 * 6. 다익스트라의 구현과정은 코드에 쓰여있다
 */
public class No1240 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i ++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());
            //방향이 없으므로
            graph.get(x).add(new Edge(y, w));
            graph.get(y).add(new Edge(x, w));
        }

        StringBuilder answer = new StringBuilder();
        int[][] distance = new int[n][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken())-1;
            int t = Integer.parseInt(st.nextToken())-1;

            //거리 값이 없을 경우만 계산
            if(distance[s][t] == 0){
                distance[s] = dijkstra(graph, s, n);
            }

            answer.append(distance[s][t]).append("\n");
        }

        System.out.println(answer);

    }

    private static int[] dijkstra(List<List<Edge>> graph, int s, int n) {
        //우선순위 큐를 weight(거리)가 작은 순으로
        PriorityQueue<Edge>
                pq = new PriorityQueue<>(Comparator.comparingInt(e->e.weight));

        //반환할 거리 배열
        int[] dist = new int[n];
        //초기값 최대값으로
        Arrays.fill(dist, Integer.MAX_VALUE);
        //출발지점 0으로 초기화
        dist[s] = 0;
        pq.offer(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            //거리를 계산 할 타겟의 거리가 현재 거리보다 작으면 그냥 넘김
            if(current.weight > dist[current.target]){
                continue;
            }
            for(Edge edge : graph.get(current.target)){
                int v = edge.target;
                int w = edge.weight;
                //타겟의 거리가 현재 내 위치에서 거리 더한 값보다 크면 바꿔줌
                if(dist[current.target] + w < dist[v]){
                    dist[v] = dist[current.target] + w;
                    pq.add(new Edge(v, dist[v]));
                }
            }
        }
        return dist;
    }

    static class Edge{
        int target;
        int weight;

        public Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
