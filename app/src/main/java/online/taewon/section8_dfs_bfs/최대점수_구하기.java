package online.taewon.section8_dfs_bfs;

import java.util.Scanner;

public class 최대점수_구하기 {
    static int n, m, maxScore;
    static int[][] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scan.nextInt();
            arr[i][1] = scan.nextInt();
        }

        DFS(0, 0, 0);

        System.out.println(maxScore);
    }

    private static void DFS(int index, int currentScore, int currentTime) {
        if(currentTime > m) return;
        if(currentScore > maxScore) maxScore = currentScore;

        if(index == n) return;

        DFS(index + 1, currentScore, currentTime);
        DFS(index + 1, currentScore + arr[index][0], currentTime+ arr[index][1]);

    }
}
