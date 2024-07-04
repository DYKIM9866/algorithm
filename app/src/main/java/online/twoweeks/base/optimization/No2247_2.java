package online.twoweeks.base.optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * 실질적 약수
 *
 */
public class No2247_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(CSOD(n));
    }

    private static long CSOD(int n) {
        long result = 0;

        // Using an array to store the sum of divisors for each number
        long[] divisorSum = new long[n + 1];

        // Calculate sum of proper divisors for each number from 1 to n
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                divisorSum[j] += i;
            }
        }

        // Sum all the proper divisor sums
        for (int i = 1; i <= n; i++) {
            result += divisorSum[i];
        }

        return result % 1_000_000;
    }
}
