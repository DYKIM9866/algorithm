package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 브론즈 2
 * 재귀의 귀재
 * 완료
 */
public class No25501 {
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            isPalindrome(str);
        }
    }

    private static void isPalindrome(String str) {
        cnt = 0;
        int right = recursion(str,0,str.length()-1);
        System.out.println(right + " " + cnt);
    }

    private static int recursion(String str, int l, int r) {
        cnt++;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        return recursion(str, l+1, r-1);
    }

}
