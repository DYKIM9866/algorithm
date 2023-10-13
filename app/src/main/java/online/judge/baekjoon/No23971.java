package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ZOAC 4
 * 완료 231012
 */
public class No23971 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = 1;
        int y = 1;
        int a = 1;
        int b = 1;
        while(x<h){
            x += n+1;
            a++;
        }
        while(y<w){
            y += m+1;
            b++;
        }
        if(x > h){
            a--;
        }
        if(y > w){
            b--;
        }
        if(a == 0){
            a += 1;
        }
        if(b == 0){
            b += 1;
        }
        System.out.println(a*b);

    }
}
