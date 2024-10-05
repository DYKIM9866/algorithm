package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 큰 증가하는 부분 수열
 * 실버 2
 */
public class No11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            dp[i] = temp;
        }

        dp[0] = arr[0];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    // 최대값 해주는 이유
                    // 비교 값과 내 자리 더한 값이 이전에 더 큰 값이 더해져있다면 그 값을 선택해야 하기 때문
                    // 6
                    // 3 1 100 4 90 30 이라면 101이 아니라 103이 되어야 한다.
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
