package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문자열
 * 완료 230926
 */
public class No9086 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        while(count-->0){
            String str = br.readLine();
            System.out.println(str.charAt(0)+""+str.charAt(str.length()-1));
        }
    }
}
