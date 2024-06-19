package online.taewon.section8_dfs_bfs;

import java.util.Scanner;

public class 중복순열 {
    static int n,m;
    static int[] printArr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        printArr = new int[m];

        DFS(0);
    }

    private static void DFS(int level) {
        if (level == m) {
            for (int x : printArr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }else{
            for (int i = 1; i <= n; i++) {
                printArr[level] = i;
                DFS(level + 1);
            }
        }
    }
}
