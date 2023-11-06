package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 유레카 이론 브론즈1
 * 미완
 */
public class No10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while(t --> 0){
            int k = Integer.parseInt(reader.readLine());
            if(run(k)){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
        }

    }
    private static boolean run(int k) {
        boolean tf = false;

        int i = 1;
        while(true){
            int a = tN(i);
            if(a >= k){
                break;
            }

        }

        return tf;
    }

    private static int tN(int n){
        return n*(n+1)/2;
    }
}
