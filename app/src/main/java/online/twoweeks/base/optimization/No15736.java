package online.twoweeks.base.optimization;

import java.util.Scanner;

/**
 * 백준
 * 청기 백기
 * 실버 4
 */
public class No15736 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(findWhite(n));
    }

    private static long findWhite(int n) {
        long i = 1;
        while(true){
            if(i*i <= n) i++;
            else {
                --i;
                break;
            }
        }
        return i;
    }
}
