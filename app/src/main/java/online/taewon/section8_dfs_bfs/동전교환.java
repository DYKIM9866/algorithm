package online.taewon.section8_dfs_bfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 동전교환 {
    static int n, m, result=501;
    static Integer[] coinType;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        coinType = new Integer[n];
        for (int i = 0; i < n; i++) {
            coinType[i] = scan.nextInt();
        }
        m = scan.nextInt();

        Arrays.sort(coinType, Collections.reverseOrder());

        DFS(0,0);
        System.out.println(result);
    }

    private static void DFS(int depth, int sum) {
        if(sum > m) return;
        if (depth >= result) return;
        if(sum == m) result = Math.min(result, depth);
        else{
            for (int x : coinType) DFS(depth+1, sum + x);
        }
    }
}
