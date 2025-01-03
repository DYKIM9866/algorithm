package online.judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Duplication {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int[][][] lcs = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                for (int k = 1; k <= str3.length(); k++) {
                    if (str1.charAt(i-1) == str2.charAt(j-1) && str2.charAt(j-1) == str3.charAt(k-1)) {
                        lcs[i][j][k] = lcs[i-1][j-1][k-1] + 1;
                    }else{
                        lcs[i][j][k] = Math.max(Math.max(lcs[i - 1][j][k], lcs[i][j - 1][k]), lcs[i][j][k - 1]);
                    }
                }
            }
        }
        System.out.println(lcs[str1.length()][str2.length()][str3.length()]);
    }
}
