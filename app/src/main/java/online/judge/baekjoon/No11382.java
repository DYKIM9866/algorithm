package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 꼬마정민
 * 완료
 */
public class No11382 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] quiz = sc.nextLine().split(" ");
        Long result = 0L;
        for(String str : quiz){
            result += Long.parseLong(str);
        }
        System.out.println(result);
    }
}
