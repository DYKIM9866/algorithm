package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 별 찍기 - 6
 * 완료 230926
 */
public class No2443 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i=N;i>=1;i--){
            for(int j=0;j<N-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
