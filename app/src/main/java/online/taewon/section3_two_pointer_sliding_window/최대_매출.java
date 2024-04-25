package online.taewon.section3_two_pointer_sliding_window;

import java.util.Scanner;

public class 최대_매출 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] sales = new int[n];
        for(int i=0;i<n;i++){
            sales[i] = scan.nextInt();
        }
        System.out.println(mySol(n, k, sales));
    }

    private static int mySol(int n, int k, int[] sales) {
        int result = 0;
        int sum = 0;
        for(int i=0;i<k;i++){
            result += sales[i];
            sum += sales[i];
        }

        for(int i=k;i<n;i++){
            sum = sum + sales[i] - sales[i-k];
            if(result < sum) result = sum;
        }
        return result;
    }
}
