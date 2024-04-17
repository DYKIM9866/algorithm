package online.hanghae99;

import java.util.Scanner;

/**
 * 3월 28일
 */
public class March28 {
    public static void main(String[] args) {

        /**
         * 프로그래머스
         * 직사각형 별찍기
         */
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        for(int i=0;i<b;i++){
            for(int j=0;j<a;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    /**
     * 프로그래머스
     * 핸드폰 번호 가리기
     */
    private static String solution(String phone_number){
        String answer = "";
        String behind = phone_number.substring(phone_number.length()-4);
        for(int i=0;i<phone_number.length()-4;i++){
            answer += "*";
        }

        return answer + behind;
    }


}

