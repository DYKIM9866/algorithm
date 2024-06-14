package online.taewon.section8_dfs_bfs;

import java.util.Scanner;

public class 바둑이_승차 {
    static int c, n, maxWeight;
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        c = scan.nextInt();
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();

        DFS(0,0);

        System.out.println(maxWeight);
    }

    private static void DFS(int i, int current) {
        if(current > c) return;
        if(current > maxWeight) maxWeight = current;

        if(i == n) return;

        DFS(i+1, current);
        DFS(i+1, current + arr[i]);
    }
}
