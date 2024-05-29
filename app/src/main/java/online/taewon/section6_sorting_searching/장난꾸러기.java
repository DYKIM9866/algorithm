package online.taewon.section6_sorting_searching;

import java.util.Scanner;

public class 장난꾸러기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(mySol(n, arr));
    }

    private static String mySol(int n, int[] arr) {
        String result = "";
        int[] notSort = new int[n];
        for(int i=0;i<n;i++){
            notSort[i] = arr[i];
        }
        quickSort(arr,0,arr.length-1);

        for(int i=0;i<n;i++){
            if(arr[i] != notSort[i]) result += i+1 + " ";
        }

        return result;
    }

    private static void quickSort(int[] arr, int start, int end) {
        if(start >= end) return;

        int pivot = start;
        int low = start + 1;
        int high = end;

        while(high >= low){
            while(low <= end && arr[low] <= arr[pivot]) low++;
            while(high > start && arr[high] >= arr[pivot]) high--;

            if(low >= high) swap(arr,pivot,high);
            else swap(arr,low,high);
        }

        quickSort(arr,start,high-1);
        quickSort(arr,high+1,end);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
