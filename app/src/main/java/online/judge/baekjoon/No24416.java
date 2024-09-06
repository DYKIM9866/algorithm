package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 브론즈1
 * 알고리즘 수업 - 피보나치 수 1
 * 완료
 */
public class No24416 {
    private static int answer1 = 1;
    private static int answer2 = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        fib(n);
        fibonacci(n);

        System.out.println(answer1 + " " + answer2);
    }

    private static long fibonacci(int n) {
        long[] f = new long[n+1];
        f[1] = 1;
        f[2] = 1;

        for(int i=3;i<=n;i++){
            answer2++;
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    private static long fib(int n) {
        if(n == 1 || n == 2) return 1;
        answer1++;
        return fib(n-1) + fib(n-2);
    }
}
