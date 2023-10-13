package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 수학은 체육과목 입니다.
 * 완료 231005
 * 걍 4곱하면됨
 */
public class No15894 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextInt();
        long result = 0;
        for(long i=0;i<n;i++){
            result += 3;
        }
        result += n;

        System.out.println(result);
    }
}
