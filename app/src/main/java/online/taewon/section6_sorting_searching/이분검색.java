package online.taewon.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 이분검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        int n = Integer.parseInt(strArr[0]);
        int m = Integer.parseInt(strArr[1]);
        int[] arr = new int[n];
        String[] intArr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(intArr[i]);
        }

        System.out.println(mySol(n,m,arr));

    }

    private static int mySol(int n, int m, int[] arr) {
        int result = -1;
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length-1;
        while(true){
            int mid = (right + left)/2;
            if(arr[mid] == m){
                result = mid + 1;
                break;
            }
            else if(arr[mid] < m) left = mid+1;
            else right = mid-1;
        }
        return result;
    }
}
