package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 두 배열의 합
 * 골드 3
 *
 */
public class No2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] nArr = new int[n];
        StringTokenizer nSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(nSt.nextToken());
            nArr[i] = x;
        }

        int m = Integer.parseInt(br.readLine());
        int[] mArr = new int[m];
        StringTokenizer mSt = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(mSt.nextToken());
            mArr[i] = x;
        }



    }

}
