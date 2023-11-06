package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 암호 키
 * 완료 231031
 */
public class No1816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            long s = Long.parseLong(br.readLine());
            for(int j=2;j<=1_000_000;j++){
                if(s%j == 0){
                    System.out.println("NO");
                    break;
                }else if(j==1_000_000){
                    System.out.println("YES");
                }
            }
        }
    }
}
