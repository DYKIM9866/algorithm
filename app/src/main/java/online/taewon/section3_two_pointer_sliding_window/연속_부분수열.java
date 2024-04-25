package online.taewon.section3_two_pointer_sliding_window;

import java.util.Scanner;

public class 연속_부분수열 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] nArr = new int[n];
        for(int i=0;i<n;i++){
            nArr[i] = scan.nextInt();
        }

        System.out.println(classSol(n,m,nArr));
    }

    private static int mySol(int n, int m, int[] nArr) {
        int result = 0;
        int lt = 0;
        int rt = 0;
        int sum = 0;

        while(rt != n){
            sum += nArr[rt++];
            if(sum > m){
                sum -= nArr[lt++];
            }
            if(sum == m){
                result++;
                sum -= nArr[lt++];
            }
        }

        while(sum > m){
            sum -= nArr[lt++];
            if(sum == m){
                result++;
            }
        }


        return result;
    }
    private static int classSol(int n, int m, int[] nArr){
        int result = 0;
        int lt = 0;
        int rt = 0;
        int sum = 0;
        while(rt < n){
            sum += nArr[rt++];
            if(sum == m) result++;
            while(sum >= m){
                sum -= nArr[lt++];
                if(sum == m) result++;
            }
        }

        return result;
    }
}
