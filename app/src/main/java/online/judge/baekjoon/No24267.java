package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 알고리즘 수업 - 알고리즘의 수행 시간 6
 * 완료 231006
 */
public class No24267 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextInt();

        System.out.println((n*(n-1)*(n-2))/6);
        System.out.println(3);

    }
}
