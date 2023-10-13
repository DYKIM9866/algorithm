package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 문자열 반복
 * 완료 230926
 */
public class No2675 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        StringBuilder sb = new StringBuilder();
        while(count-->0){
            int r = scan.nextInt();
            String S = scan.next();

            for(int i=0;i<S.length();i++){
                for(int j=0;j<r;j++){
                    sb.append(S.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
