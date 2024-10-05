package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 밤양갱
 * 실버
 */
public class No31926 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int answer = 10;
        int x = 1;
        while(n >= x * 2){
            x *= 2;
            answer++;
        }

        System.out.println(answer);
    }
}
