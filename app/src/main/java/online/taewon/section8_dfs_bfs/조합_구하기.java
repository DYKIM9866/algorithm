package online.taewon.section8_dfs_bfs;

import java.util.Scanner;

public class 조합_구하기 {
    static int n,r;
    static int[] com;
    static boolean[] check;

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            n = scan.nextInt();
            r = scan.nextInt();
            check = new boolean[n + 1];
            com = new int[r];

            sol(0,1);
        }
    }

    private static void sol(int depth, int num) {
        if(depth == r) {
            for(int i=0;i<r;i++) System.out.print(com[i] +" ");
            System.out.println();
            return;
        }
        for (int i = num; i <= n; i++) {
            if(!check[i]){
                check[i] = true;
                com[depth] = i;
                sol(depth + 1, num + i);
                check[i] = false;
            }
        }
    }
}
