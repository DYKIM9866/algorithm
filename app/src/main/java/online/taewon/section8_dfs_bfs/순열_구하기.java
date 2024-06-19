package online.taewon.section8_dfs_bfs;

import java.util.Scanner;

public class 순열_구하기 {
    static int n,m;
    static boolean check[];
    static int arr[], pm[];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n];
        pm = new int[m];
        check = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        sol(0);
    }

    private static void sol(int depth) {
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(pm[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!check[i]){
                check[i] = true;
                pm[depth] = arr[i];
                sol(depth + 1);
                check[i] = false;
            }
        }

    }


}
