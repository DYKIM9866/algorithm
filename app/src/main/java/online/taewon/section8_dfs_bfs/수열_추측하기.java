package online.taewon.section8_dfs_bfs;

import java.util.Scanner;

public class 수열_추측하기 {
    static int n, f;
    static int[] result, dp;
    static boolean flag = false;
    static boolean[] check;
    static int[][] combi = new int[11][11];
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            n = scan.nextInt();
            f = scan.nextInt();
            dp = new int[n];

            for (int i = 0; i < n; i++) {
                dp[i] = combination(n-1,i);
            }
            result = new int[n];
            check = new boolean[n+1];

            dfs(0, 0);
        }
    }

    private static int combination(int n, int r) {
        if(combi[n][r] != 0) return combi[n][r];
        if(n == r || r==0) return 1;

        return combi[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }

    private static void dfs(int depth, int sum) {
        if(flag) return;
        if(depth == n){
            if(sum == f){
                for(int x : result) System.out.print(x + " ");
                flag = true;
            }
        }else{
            for (int i = 1; i <= n; i++) {
                if (!check[i]) {
                    check[i] = true;
                    result[depth] = i;
                    dfs(depth+1, sum + (result[depth] * dp[depth]));
                    check[i] = false;
                }
            }
        }
    }
}
