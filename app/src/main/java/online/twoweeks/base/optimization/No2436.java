package online.twoweeks.base.optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준
 * 공약수
 * 골드 5
 */
public class No2436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gcd = Integer.parseInt(st.nextToken());
        int lcd = Integer.parseInt(st.nextToken());

        long mul = (long) gcd * lcd;
        
        int a=0,b = 0;

        for (int x = gcd; x <= Math.sqrt(mul); x += gcd) {
            if(mul % x == 0 && euclidean(x, mul/x) == gcd){
                a = x;
                b = (int)(mul/x);
            }
        }

        System.out.println(a + " " + b);
    }

    private static long euclidean(long x, long y) {
        long r = x%y;
        if(r == 0){
            return y;
        }
        return euclidean(y,r);
    }

}
