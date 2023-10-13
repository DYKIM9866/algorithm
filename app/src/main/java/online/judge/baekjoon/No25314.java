package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 코딩은 체육과목 입니다
 * 완료 230926
 */
public class No25314 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int nByte = scan.nextInt();
        String addLong = "long";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<nByte/4;i++){
            sb.append(addLong + " ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}
