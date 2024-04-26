package online.taewon.section3_two_pointer_sliding_window;

import java.util.Scanner;

public class 최대_길이_연속부분수열 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = scan.nextInt();
        }

        System.out.println(mySol(n,k,array));
    }

    private static int mySol(int n, int k, int[] array) {
        int result = 0;
        int lt = 0;
        int rt = 0;
        int cnt =0;
        while(rt <= n-1){
            if(array[rt] == 0){
                cnt++;
            }
            while(cnt > k){
                if(array[lt++] == 0) cnt--;
            }
            result = result > rt-lt+1 ? result : rt-lt+1;
            rt++;
        }

        return result;
    }
}
