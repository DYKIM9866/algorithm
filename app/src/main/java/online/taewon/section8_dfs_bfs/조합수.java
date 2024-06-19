package online.taewon.section8_dfs_bfs;

import java.util.Scanner;

public class 조합수 {
    static int[][] dp = new int[35][35];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = scan.nextInt();

        System.out.println(sol(n, r));
        System.out.println(sol2(n,r));
    }

    private static int sol(int n, int r) {
        if(dp[n][r] > 0) return dp[n][r];
        if (n == r || r==0) return 1;
        return dp[n][r] = sol(n - 1, r - 1) + sol(n - 1, r);
    }

    private static int sol2(int n, int r) {

        int[][] ddp = new int[n + 1][r + 1];

        for (int i = 0; i <= n; i++) {
            ddp[i][0] = 1;
            for (int j = 1; j <= Math.min(i, r); j++) {
                if(i == j) ddp[i][j] = 1;
                else ddp[i][j] = ddp[i - 1][j - 1] + ddp[i - 1][j];
            }
        }
        return ddp[n][r];
    }

}
