package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 분수찾기
 * 완료 231005
 */
public class No1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b;
        int c = 0;
        int sum = 0;
        for(int i=1;i<=4472;i++){
            sum += i;
            if(sum >= a){
                sum -= i;
                c = i;
                break;
            }
        }
        b = a - sum;

        if(c%2 == 0){
            System.out.println(Integer.toString(b) + "/" + Integer.toString(c-b +1));
        }else{
            System.out.println(Integer.toString(c-b+1) + "/" + Integer.toString(b));
        }

    }
}
