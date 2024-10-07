package online.judge.baekjoon;

import java.util.*;

/**
 * 택배 배송
 * 골드 5
 */
public class No5972 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //헛간의 수와 연결 길 개수
        int n = scan.nextInt();
        int m = scan.nextInt();

        //그래프 초기화
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scan.nextInt()-1;
            int b = scan.nextInt()-1;
            int c = scan.nextInt();

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        System.out.println(dijkstra(n, m, graph));
    }

    private static int dijkstra(int n, int m, List<List<int[]>> graph) {
        PriorityQueue<int[]> pq
                = new PriorityQueue<>(Comparator.comparingInt(e->e[1]));
        int[] dis = new int[n];

        //초기값
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int v = current[0];
            int w = current[1];

            if(w > dis[v]) continue;

            for(int[] next : graph.get(v)){
                if(dis[v] + next[1] < dis[next[0]]){
                    dis[next[0]] = dis[v] + next[1];
                    pq.offer(new int[]{next[0], dis[next[0]]});
                }
            }
        }
        return dis[n-1];
    }
}
