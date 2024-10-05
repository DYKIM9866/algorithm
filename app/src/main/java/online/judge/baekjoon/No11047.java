package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 동전 0
 * 실버 4
 */
public class No11047 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = scan.nextInt();
        }

        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            int temp = k/coin[i];
            //지금 동전으로 거슬러줄 수 있으면 최대한 거슬러 주고 넘어간다.
            if(temp > 0){
                cnt += temp;
                k -= temp * coin[i];
                if(k == 0) break;
            }
        }
        System.out.println(cnt);
    }
}
