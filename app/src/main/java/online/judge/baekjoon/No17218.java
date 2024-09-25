package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드 4
 * 비밀번호 만들기
 *
 */
public class No17218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String password1 = br.readLine();
        String password2 = br.readLine();
        String answer = "";
        StringBuilder make = new StringBuilder();

        for(int i=0;i<password1.length();i++){
            StringBuilder password2Sb = new StringBuilder(password2);
            for(int j=i;j<password1.length();j++){
                char alpha = password1.charAt(j);
                int x = password2Sb.indexOf(String.valueOf(alpha));
                if(x != -1){
                    make.append(password2Sb.charAt(x));
                    password2Sb = new StringBuilder(password2Sb.substring(x+1));
                }
            }
            answer = answer.length() > make.length() ?  answer:make.toString();
            make.setLength(0);
        }
        System.out.println(answer);
    }

}
