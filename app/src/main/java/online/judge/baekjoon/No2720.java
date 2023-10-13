package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 세탁소 사장 동혁
 * 완료 230927
 */
public class No2720 {
    public static int[] cent = {25,10,5,1};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int t = scan.nextInt();
        for(int i=0;i<t;i++){
            int c = scan.nextInt();
            for(int j=0;j<cent.length;j++){
                sb.append(c/cent[j]);
                c %= cent[j];
                if(j<cent.length-1){
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
