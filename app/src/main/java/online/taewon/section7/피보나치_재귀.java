package online.taewon.section7;

import java.util.Scanner;

/**
 * 메모이제이션
 */
public class 피보나치_재귀 {

    static int[] fibo;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        fibo = new int[n + 1];
        mySol(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }

    }

    private static int mySol(int n) {
        if(fibo[n] > 0) return fibo[n];
        if(n == 1 || n == 2) return fibo[n] = 1;
        else return fibo[n] = mySol(n - 2) + mySol(n - 1);
    }
}
