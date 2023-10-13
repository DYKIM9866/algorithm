package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 별찍기 - 7
 * 완료 230926
 */
public class No2444 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=N-1;i>0;i--){
            for(int j=1;j<=N-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }


    }
}

