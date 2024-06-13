package online.taewon.section7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * bfs
 */
public class 그래프_최단거리 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] dis = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph[a][b] = 1;
        }

        BFS(n,dis,graph);

        for (int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    private static void BFS(int n, int[] dis, int[][] graph) {
        Deque<Integer> que = new ArrayDeque<>();
        int length = 0;

        que.offer(1);

        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int v = que.poll();
                if(dis[v] == 0) {
                    dis[v] = length;
                    for (int j = 1; j <= n; j++) {
                        if(graph[v][j] == 1) que.offer(j);
                    }
                }
            }
            length++;
        }
    }
}
