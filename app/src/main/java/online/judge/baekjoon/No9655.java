package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 돌 게임
 * 완료 231011
 * 결국 1,2,3의 경우만 알고 있으면 되는 거
 */
public class No9655 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n%2 == 0){
            System.out.println("CY");
        }else {
            System.out.println("SK");
        }
    }
}
