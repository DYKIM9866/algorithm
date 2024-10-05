package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 거스름돈
 * 실버 5
 */
public class No14916 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int cnt = 0;
        for (int i = n/5; i >= 0 / 5; i--) {
            if((n - (i*5)) % 2 == 0){
                n -= i*5;
                cnt += i;
                break;
            }
        }
        if(n % 2 == 0){
            cnt += n/2;
        }else {
            cnt = -1;
        }

        System.out.println(cnt);
    }
}
