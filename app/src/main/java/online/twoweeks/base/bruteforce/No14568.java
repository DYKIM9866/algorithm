package online.twoweeks.base.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * 2017 연세대학교 프로그래밍 경시대회
 * 브론즈3
 */
public class No14568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(distributeCandy(n));
    }

    private static int distributeCandy(int n) {
        int result = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if(i+j+k == n){
                        if(i-j >= 2){
                            if(k % 2 == 0){
                                result++;
                            }
                        }
                    }
                }
            }
        }


        return result;
    }
}
