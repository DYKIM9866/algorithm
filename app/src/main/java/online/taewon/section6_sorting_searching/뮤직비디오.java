package online.taewon.section6_sorting_searching;

import java.util.Scanner;

/**
 * 9 3
 * 1 2 3 4 5 6 7 8 9
 */

public class 뮤직비디오 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(mySol(n,m,arr));
    }

    private static int mySol(int n, int m, int[] arr) {
        int lt=0,rt=0;
        for(int i=0;i<n;i++){
            rt+=arr[i];
            lt = Math.max(lt, arr[i]);
        }
        while (lt < rt) {
            int mid = (lt+rt)/2;
            if(isEnough(mid, arr, m)){
                rt = mid;
            }else{
                lt = mid+1;
            }
        }

        return lt;
    }

    private static boolean isEnough(int mid, int[] arr, int m) {
        int[] cdArr = new int[m+1];
        int cdIdx = 0;
        int timeIdx = 0;
        while(cdIdx < m && timeIdx < arr.length){
            cdArr[cdIdx] += arr[timeIdx];
            if(cdArr[cdIdx] > mid){
                cdArr[cdIdx++] -= arr[timeIdx];
                continue;
            }
            timeIdx++;
        }
        if(cdIdx >= m) return false;
        return true;
    }
}
