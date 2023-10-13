package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 공 바꾸기
 * 완료 230926
 */
public class No10813 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] basket = new int[N];
        for(int i=1;i<=basket.length;i++){
            basket[i-1] = i;
        }

        while(M-->0){
            int i = scan.nextInt();
            int j = scan.nextInt();
            int temp = basket[i-1];
            basket[i-1] = basket[j-1];
            basket[j-1] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i< basket.length;i++){
            sb.append(basket[i]);
            if(i< basket.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
