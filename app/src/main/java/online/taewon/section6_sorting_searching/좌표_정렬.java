package online.taewon.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 좌표_정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(strArr[0]);
            arr[i][1] = Integer.parseInt(strArr[1]);
        }

        System.out.println(mySol(n, arr));
    }

    private static String mySol(int n, int[][] arr) {
        String result = "";
        mergeSort(arr, 0, arr.length-1);

        for(int i=0;i<n;i++){
            result += arr[i][0] + " " + arr[i][1];
            if(i < n-1) result += "\n";
        }

        return result;
    }

    private static void mergeSort(int[][] arr, int start, int end) {
        if(start >= end) return;

        int mid = (start + end)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[][] arr, int start, int mid, int end) {
        int[][] temp = new int[end-start+1][2];

        int idx = 0;
        int left = start;
        int right = mid+1;

        while (left <= mid && right <= end) {
            if(arr[left][0] < arr[right][0]){
                temp[idx][0] = arr[left][0];
                temp[idx][1] = arr[left][1];
                idx++;
                left++;
            }else if(arr[left][0] == arr[right][0]){
                if(arr[left][1] <= arr[right][1]){
                    temp[idx][0] = arr[left][0];
                    temp[idx][1] = arr[left][1];
                    idx++;
                    left++;
                }else{
                    temp[idx][0] = arr[right][0];
                    temp[idx][1] = arr[right][1];
                    idx++;
                    right++;
                }
            }else{
                temp[idx][0] = arr[right][0];
                temp[idx][1] = arr[right][1];
                idx++;
                right++;
            }
        }

        while(left <= mid){
            temp[idx][0] = arr[left][0];
            temp[idx][1] = arr[left][1];
            idx++;
            left++;
        }
        while(right <= end){
            temp[idx][0] = arr[right][0];
            temp[idx][1] = arr[right][1];
            idx++;
            right++;
        }

        for(int i=start;i<=end;i++){
            arr[i][0] = temp[i-start][0];
            arr[i][1] = temp[i-start][1];
        }
    }


}
