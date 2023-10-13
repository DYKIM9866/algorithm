package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 대지
 * 완료 231005
 */
public class No9063 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = 10001;
        int y = 10001;
        int l = -10001;
        int k = -10001;
        int n = Integer.parseInt(reader.readLine());
        while(n-->0){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if(i < x){
                x = i;
            }
            if(i > l){
                l = i;
            }
            if(j < y){
                y = j;
            }
            if(j > k){
                k = j;
            }
        }
        System.out.println((l-x)*(k-y));
    }
}
