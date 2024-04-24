package online.taewon.section2_Array;

import java.util.Scanner;
import java.util.TreeMap;

public class 봉우리 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] grid = new int[n+2][n+2];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                grid[i][j] = scan.nextInt();
            }
        }

        System.out.println(mySol(n, grid));
    }

    private static int mySol(int n, int[][] grid) {
        int result = 0;
        //상하좌우
        int[] x = {-1,1,0,0};
        int[] y = {0,0,-1,1};
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                boolean flag = true;
                for(int k=0;k<4;k++){
                    int move = grid[i-x[k]][j-y[k]];
                    if(move >= grid[i][j]) flag = false;
                }
                if(flag) result++;
            }
        }
        return result;
    }
}
