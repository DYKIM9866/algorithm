package online.twoweeks.base.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준
 * 암호 키
 * 브론즈 1
 */
public class No1816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            long s = Long.parseLong(br.readLine());
            if(isCorrect(s)){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            if(i < n-1) sb.append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isCorrect(long n) {
        boolean result = true;
        int[] standard = new int[1_000_001];
        int i = 2;
        while(i < 1_000_000){
            if(standard[i] != 1){
                if(n % i == 0) {
                    result = false;
                    break;
                }
                for(int j=i;j<standard.length;j+=i){
                    standard[j] = 1;
                }
            }
            i++;
        }


        return result;
    }
}
