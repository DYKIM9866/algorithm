package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LCS3
 * 골드 4
 * 문제 해석
 * 1. 세 숫자의 Longest Common Subsequence를 찾아라
 *
 * 문제 풀이
 * 1. 두개의 lcs를 구할 때랑 같이 생각해주면 된다.
 * 2. 삼차원 배열을 선언해준다
 * 3. 만약 값이 같다면 이전 common subsequence 값에 1을 더해준다.
 * 4. 아니라면 각 문자의 이전 common subsequence의 최대값을 넣어준다.
 */
public class No1958 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String f = br.readLine();
        String s = br.readLine();
        String t = br.readLine();

        System.out.println(longestCommonSubstring(f,s,t));
    }

    private static int longestCommonSubstring(String f, String s, String t) {
        int[][][] lcs = new int[f.length() + 1][s.length() + 1][t.length() + 1];

        for (int i = 1; i <= f.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                for (int k = 1; k <= t.length(); k++) {
                    if (f.charAt(i - 1) == s.charAt(j - 1) && s.charAt(j - 1) == t.charAt(k - 1)) {
                        lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
                    } else {
                        lcs[i][j][k] = Math.max(lcs[i - 1][j][k], Math.max(lcs[i][j - 1][k], lcs[i][j][k - 1]));
                    }
                }
            }
        }

        return lcs[f.length()][s.length()][t.length()];
    }
}
