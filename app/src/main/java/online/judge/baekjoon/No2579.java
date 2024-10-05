package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 계단 오르기
 *
 */
public class No2579 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = scan.nextInt();
        }

        if(n == 1){
            System.out.println(arr[1]);
            return;
        }

        int[] dp = new int[n+1];

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }

        System.out.println(dp[n]);

    }
}
