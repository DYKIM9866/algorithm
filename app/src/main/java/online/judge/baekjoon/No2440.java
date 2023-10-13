package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 별 찍기 - 3
 *완료 230926
 */
public class No2440 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        for(int i=0;i<N;i++){
            for(int j=N-1;j>=0;j--){
                if(j>=i){
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}
