package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 별 찍기 - 1
 * 완료 230926
 */
public class No2438 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for(int i=0;i<N;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
