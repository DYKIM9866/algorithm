package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 별 찍기 - 2
 *완료 230926
 */
public class No2439 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for(int i=0;i<N;i++){
            for(int j=N-1;j>=0;j--){
                if(i>=j){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
