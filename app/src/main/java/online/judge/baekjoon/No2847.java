package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 게임을 만든 동준이
 * 실버 4
 */
public class No2847 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        int answer = 0;
        for(int i=n-2;i>=0;i--){
            if(arr[i+1] > arr[i]) continue;
            int temp = arr[i + 1] - 1;
            answer += arr[i] - temp;
            arr[i] = temp;
        }
        System.out.println(answer);
    }
}
