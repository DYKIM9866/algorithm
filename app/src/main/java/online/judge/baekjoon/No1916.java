package online.judge.baekjoon;

import java.util.*;

/**
 * 최소비용 구하기
 * 골드 5
 */
public class No1916 {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //도시의 개수
        n = scan.nextInt();
        //버스의 개수
        m = scan.nextInt();

        //그래프 초기화
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        //그래프 담기
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            int weight = scan.nextInt();

            graph.get(a).add(new int[]{b, weight});
        }

        //출발지 - 도착지
        int start = scan.nextInt()-1;
        int arrive = scan.nextInt()-1;

        //출력
        System.out.println(dijkstra(graph, start, arrive));
    }

    private static int dijkstra(List<List<int[]>> graph, int start, int arrive) {
        //우선순위 큐 사용, 가중치를 기준으로 정렬
        PriorityQueue<int[]> pq
                = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));

        //거리 담을 배열
        int[] dis = new int[n];

        //초기 값 세팅
        pq.offer(new int[]{start, 0});
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[start] = 0;

        //시작
        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int v = current[0];
            int w = current[1];
            if(w > dis[v]) continue;

            for(int[] next : graph.get(v)){
                if(dis[next[0]] > dis[v] + next[1]){
                    dis[next[0]] = dis[v] + next[1];
                    pq.offer(new int[]{next[0], dis[next[0]]});
                }
            }
        }

        return dis[arrive];
    }
}
