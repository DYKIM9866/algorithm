package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 2017 연세대학교 프로그래밍 경시대회
 * 완료 완전탐색 231031
 */
public class No14568 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int result = 0;

        for(int i=0;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                for(int k=0;k<n+1;k++){
                    if((i+j+k) == n){
                        if(i != 0 && j != 0 && k != 0){
                            if((j-i) >= 2){
                                if(k%2 == 0){
                                    result++;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);

    }
}
