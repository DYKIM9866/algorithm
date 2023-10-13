package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 알고리즘 수업 - 점근적 표기 1
 * 미완
 */
public class No24313 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int y = scan.nextInt();
        int c = scan.nextInt();
        int no = scan.nextInt();

        if(no >= (-y)/(x-c)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
