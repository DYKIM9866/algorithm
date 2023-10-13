package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 문자와 문자열
 * 완료 230926
 */
public class No27866 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int i = scan.nextInt();
        System.out.println(str.charAt(i-1));
    }
}
