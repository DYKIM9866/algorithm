package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 행렬 덧셈
 * 시간 안될 줄 알았는데 되네;
 * 완료 230927
 */
public class No2738 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int[][] sum = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sum[i][j] += scan.nextInt();
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sum[i][j] += scan.nextInt();
                System.out.print(sum[i][j]);
                if(j<M-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
