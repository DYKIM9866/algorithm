package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PublicKey;
import java.util.Arrays;

/**
 * 1,2,3 더하기 실버3
 * 미완
 */
public class No9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while(t-->0){
            int n = Integer.parseInt(reader.readLine());
            int count = 1;
            if(n == 1){
                System.out.println(1);
                continue;
            }
            // 2가 포함 될 경우
            if(n == 2){
                System.out.println(2);
                continue;
            }

            int a = n/2;
            for(int i=1;i<=a;i++){

            }

        }
    }
    private int facto(int v){
        if(v == 1){
            return 1;
        }
        if(v == 2){
            return 2;
        }
        return facto(v-1);
    }
}
