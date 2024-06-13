package online.taewon.section7;

import java.util.Scanner;

/**
 * DFS
 */
public class 경로탐색_DFS {
    static int n;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int m = scan.nextInt();
        graph = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
           int a = scan.nextInt();
           int b = scan.nextInt();
           graph[a][b] = 1;
        }

        System.out.println(dfsSol());
    }


    private static int dfsSol() {
        int result = 0;
        int[] check = new int[n + 1];
        check[1] = 1;
        result += DFS(1, check);

        return result;
    }

    private static int DFS(int start,int[] check) {
        int sum = 0;
        if(start == n) return 1;
        else {
            for (int i = 1; i <= n; i++) {
                if(graph[start][i] == 1 && check[i] == 0){
                    check[i] = 1;
                    sum += DFS(i, check);
                    check[i] = 0;
                }
            }
        }

        return sum;
    }

}
