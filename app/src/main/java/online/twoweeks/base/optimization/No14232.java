package online.twoweeks.base.optimization;

import java.util.Scanner;

/**
 * 백준
 * 보석 도둑
 * 실버 1
 */
public class No14232 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long k = scan.nextLong();

        stone(k);
    }

    private static void stone(long k) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();

        for (long i = 2; i * i <= k; i++) {
            while(k%i==0){
                cnt++;
                sb.append(i).append(" ");
                k/=i;
            }
        }

        if(k > 1) {
            cnt++;
            sb.append(k);
        }

        System.out.println(cnt);
        System.out.println(sb.toString().trim());

    }
}
