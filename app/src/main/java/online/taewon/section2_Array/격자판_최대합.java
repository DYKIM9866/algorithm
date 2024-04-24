package online.taewon.section2_Array;

import java.util.Scanner;

public class 격자판_최대합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] grid = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                grid[i][j] = scan.nextInt();
            }
        }

        System.out.println(mySol(n, grid));
    }

    private static int mySol(int n, int[][] grid) {
        int result = 0;
        //행열
        for(int i=0;i<n;i++){
            int sum1=0, sum2 = 0;
            for(int j=0;j<n;j++){
                sum1 += grid[i][j];
                sum2 += grid[j][i];
            }
            if(sum1 > result){
                result = sum1;
            }
            if(sum2 > result){
                result = sum2;
            }
        }

        //대각
        int sum1=0,sum2=0;
        for(int i=0;i<n;i++){
            sum1 += grid[i][i];
            sum2 += grid[i][n-1-i];
        }
        if(sum1 > result){
            result = sum1;
        }
        if(sum2 > result){
            result = sum2;
        }
        return result;
    }
}
