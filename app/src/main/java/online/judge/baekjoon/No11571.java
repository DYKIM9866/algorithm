package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드 5
 * 분수를 소수로
 * 미완
 */
public class No11571 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            String[] xy = br.readLine().split(" ");
            System.out.println(
                    recurringDecimal(Integer.parseInt(xy[0])
                            , Integer.parseInt(xy[1])));
        }
    }

    private static String recurringDecimal(int x, int y){
        StringBuilder sb = new StringBuilder();

        sb.append(x/y).append(".");

        int target = x%y;
        int divide = y;
        while(true){
            if(target == 0){
                sb.append("(0)");
                break;
            }else{
                target *= 10;
                int val = target / divide;
                target %= divide;
            }
        }

        return sb.toString();
    }
}
