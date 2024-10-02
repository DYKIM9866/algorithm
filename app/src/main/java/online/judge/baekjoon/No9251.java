package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * LCS
 */
public class No9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String f = br.readLine();
        String s = br.readLine();

        System.out.println(lcSubsequence(f,s));
    }

    private static int lcSubsequence(String f, String s) {
        int[][] lcs = new int[f.length()+1][s.length()+1];

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= f.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                if(f.charAt(i-1) == s.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
                max = Math.max(max, lcs[i][j]);
            }
        }
        return max;
    }
}
