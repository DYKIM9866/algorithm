package online.twoweeks.base.optimization;

import java.util.Scanner;

/**
 * 백준
 * 소인수분해
 * 브론즈 1
 */
public class No11653 {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int n = scan.nextInt();

            primeFactorization(n);
        }
    }

    private static void primeFactorization(int n) {

        while(true){
            if(n == 1) return;
            int a = 0;
            for(int i=2;i<=n;i++){
                if(n % i == 0) {
                    System.out.println(i);
                    a = i;
                    break;
                }
            }
            n/=a;
        }


    }

}
