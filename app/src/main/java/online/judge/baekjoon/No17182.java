package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 우주 탐사선
 * 골드 3
 */
public class No17182 {
    static boolean[] visited;
    static int n;
    static int answer = Integer.MAX_VALUE;
    static int[][] graph;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        int k = scan.nextInt();

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {   //거쳐오기
            for (int j = 0; j < n; j++) {   //출발
                for (int l = 0; l < n; l++) {   //도착
                    if (j == l) continue;
                    if (graph[j][l] > graph[j][i] + graph[i][l]) {
                        graph[j][l] = graph[j][i] + graph[i][l];
                    }
                }
            }
        }

        visited = new boolean[n];
        visited[k] = true;

        dfs(k, 0, 0);

        System.out.println(answer);

    }

    private static void dfs(int k, int sum, int depth) {
        if(depth == n-1){
            answer = Math.min(answer, sum);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i] || i == k) continue;
            visited[i] = true;
            dfs(i, sum + graph[k][i], depth+1);
            visited[i] = false;
        }
    }

}
