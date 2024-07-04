package online.twoweeks.base.optimization;

import java.util.Scanner;

/**
 * 백준
 * 소수 찾기
 * 브론즈 2
 */
public class No1978 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (divisor(scan.nextInt())) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean divisor(int v) {
        if(v == 1) return false;

        int stand = (int) Math.pow(v, 0.5);
        for (int i = 2; i <= stand; i++) {
            if(v % i == 0) return false;
        }

        return true;
    }

}
