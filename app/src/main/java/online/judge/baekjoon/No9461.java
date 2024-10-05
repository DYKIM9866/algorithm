package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 파도반 수열
 * 실버 3
 */
public class No9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] wave = new long[101];
        wave[1] = 1;
        wave[2] = 1;
        wave[3] = 1;
        wave[4] = 2;
        wave[5] = 2;
        for (int i = 6; i <= 100; i++) {
            wave[i] = wave[i-1] + wave[i-5];
        }
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append(wave[Integer.parseInt(br.readLine())])
                    .append("\n");
        }
        System.out.println(sb);
    }
}
