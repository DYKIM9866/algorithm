package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * A와 B
 * 골드 5
 */
public class No12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder t = new StringBuilder(br.readLine());

        while(s.length() != t.length()){
            if(t.charAt(t.length()-1) == 'B'){
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }else{
                t.deleteCharAt(t.length()-1);
            }
        }

        if(s.contentEquals(t)) System.out.println(1);
        else System.out.println(0);
    }
}
