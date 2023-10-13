package online.judge.baekjoon;

import java.util.Scanner;
import java.util.Stack;

/**
 * 바구니 뒤집기
 * 완료 230926
 */
public class No10811 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int[] basket = new int[N];
        for(int i=0;i<basket.length;i++){
            basket[i] = i+1;
        }
        while (M-->0){
            int i = scan.nextInt();
            int j = scan.nextInt();
            Stack<Integer> stack = new Stack<>();
            for(int k=i;k<=j;k++){
                stack.push(basket[k-1]);
            }
            for(int k=i;k<=j;k++){
                basket[k-1] = stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<basket.length;i++){
            sb.append(basket[i]);
            if(i<basket.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
