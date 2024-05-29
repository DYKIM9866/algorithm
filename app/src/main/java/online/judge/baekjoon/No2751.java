package online.judge.baekjoon;

import java.io.*;

/**
 * 수 정렬하기2
 */
public class No2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, arr.length-1);

        for(int i=0;i<n;i++){
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();

    }


    private static void mergeSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int mid = (end + start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int idx = 0;
        int left = start;
        int right = mid+1;
        while(left <= mid && right <= end){
            if(arr[left] <= arr[right]){
                temp[idx++] = arr[left++];
            }else {
                temp[idx++] = arr[right++];
            }
        }
        while(left <= mid){
            temp[idx++] = arr[left++];
        }
        while(right <= end){
            temp[idx++] = arr[right++];
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i-start];
        }
    }
}
