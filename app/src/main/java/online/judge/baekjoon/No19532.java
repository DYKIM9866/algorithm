package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 수학은 비대면강의입니다.
 * 인프런 알고
 * 231031
 */
public class No19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for(int x =-999;x<1000;x++){
            for(int y = -999;y<1000;y++){
                if(a*x+b*y == c){
                    if(d*x+e*y == f){
                        System.out.print(x + " " + y);
                    }
                }
            }
        }

    }
}
