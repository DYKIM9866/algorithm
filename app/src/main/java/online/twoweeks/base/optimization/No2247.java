package online.twoweeks.base.optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * 실질적 약수
 * 골드 5
 */
public class No2247 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(CSOD(n));
    }

    private static long CSOD(int n) {
        long result = 0;

        for(int i=2;i<=n/2;i++){
            result += (long) (n / i - 1) * i;
        }

        return result%1_000_000;
    }

}
