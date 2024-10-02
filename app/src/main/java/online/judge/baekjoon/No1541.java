package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 잃어버린 괄호
 * 실버 2
 */
public class No1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] minusGroup = br.readLine().split("-");

        int answer = Integer.MIN_VALUE;
        for (String str : minusGroup) {
            StringTokenizer st = new StringTokenizer(str,"+");

            int cnt = 0;
            while(st.hasMoreTokens()){
                cnt += Integer.parseInt(st.nextToken());
            }

            if(answer == Integer.MIN_VALUE) answer = cnt;
            else answer -= cnt;
        }

        System.out.println(answer);
    }
}
