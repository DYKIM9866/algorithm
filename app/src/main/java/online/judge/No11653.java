package online.judge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 소인수분해
 * 완료 231005
 */
public class No11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        while(true){
            int a = min(n);
            if(a==0){
                break;
            }
            n /= a;
            System.out.println(a);
        }
    }

    private static int min(int n) {
        if (n == 1){
            return 0;
        }
        for(int i=2;i<=n;i++){
            if(n%i == 0){
                return i;
            }
        }
        return 0;
    }
}
