package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2644_2 {
    private static int n, target;
    private static boolean[][] relation;
    private static boolean[] visited;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        relation = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer pc = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(pc.nextToken());
            int y = Integer.parseInt(pc.nextToken());
            relation[x][y] = true;
            relation[y][x] = true;
        }

        dfs(start, 0);
        System.out.println(result);
    }

    private static void dfs(int current, int count) {
        if (current == target) {
            result = count;
            return;
        }

        visited[current] = true;

        for (int i = 1; i <= n; i++) {
            if (relation[current][i] && !visited[i]) {
                dfs(i, count + 1);
            }
        }

        visited[current] = false; // 백트래킹
    }
}

