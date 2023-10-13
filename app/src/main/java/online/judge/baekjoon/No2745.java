package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 진법 변환
 * 완료 230927
 */
public class No2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        char[] N = st.nextToken().toCharArray();
        int B = Integer.parseInt(st.nextToken());
        int len = N.length;
        int i = 0;
        long result = 0;
        while(len --> 0){
            if((int)N[i] < 65){
                result += Math.pow(B,len) * ((int)N[i++]-48);
            }else{
                result += Math.pow(B,len) * ((int)N[i++]-55);
            }
        }
        System.out.println(result);

    }
}
