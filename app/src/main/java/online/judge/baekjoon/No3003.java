package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 킹, 퀸, 룩, 비숍, 나이트, 폰
 * 완료 230926
 */
public class No3003 {
    public static void main(String[] args) {
        int[] chess = {1, 1, 2, 2, 2, 8};
        Scanner scan = new Scanner(System.in);

        String[] str = scan.nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length;i++){
            sb.append(chess[i] - Integer.parseInt(str[i]));
            if(i< str.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
