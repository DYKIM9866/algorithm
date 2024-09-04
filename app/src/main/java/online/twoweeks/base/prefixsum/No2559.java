package online.twoweeks.base.prefixsum;

import java.util.Scanner;

/**
 * 백준
 * 수열
 * 실버 3
 */
public class No2559 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] sumArr = new int[n+1];
        int temp = 0;
        for (int i = 1; i <= n; i++) {
            int val = scan.nextInt();
            temp += val;
            sumArr[i] = temp;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            maxSum = Math.max(sumArr[i] - sumArr[i - k], maxSum);
        }

        System.out.println(maxSum);
    }
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int n = scan.nextInt();
//        int k = scan.nextInt();
//        int[] temp = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            temp[i] = scan.nextInt();
//        }
//
//        System.out.println(continuousTemperature(n, k, temp));
//    }
//
//    private static int continuousTemperature(int n, int k, int[] temp) {
//        int result = Integer.MIN_VALUE;
//        int sum = 0;
//        int lt = 0;
//        int rt = 0;
//
//        while(rt != n){
//            sum += temp[rt];
//            if(rt - lt == k-1){
//                result = Math.max(result, sum);
//                sum -= temp[lt++];
//            }
//
//            rt++;
//        }
//
//        return result;
//    }
}
