package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 비슷한 단어
 * 골드 4
 *
 */
public class No2179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] strArr = new String[n];
        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }

        int a = 0, b = 0, max = 0;
        for (int i = 0; i < n - 1; i++) {
            //max값보다 짧은 문자열이라면 비교 할 필요 없음
            if(max >= strArr[i].length()) continue;
            for (int j = i+1; j < n; j++) {
                //max값보다 짧은 문자열이라면 비교 할 필요 없음
                if(max >= strArr[j].length()) continue;
                int cnt = 0;
                int repeat = Math.min(strArr[i].length(), strArr[j].length());
                for (int k = 0; k < repeat; k++) {
                    if(strArr[i].charAt(k) == strArr[j].charAt(k)) cnt++;
                    else break;
                }

                if(cnt > max){
                    max = cnt;
                    a = i;
                    b = j;
                }
            }
        }

        System.out.println(strArr[a]);
        System.out.print(strArr[b]);
    }
}
