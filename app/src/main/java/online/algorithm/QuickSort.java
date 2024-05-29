package online.algorithm;

import java.lang.annotation.IncompleteAnnotationException;
import java.util.Scanner;

/**
 * 퀵 정렬
 * 미완 어려움..
 */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        quickSort(arr, 0, arr.length-1);

        for(int x : arr){
            System.out.print(x + " ");
        }
    }

    private static void quickSort(int[] intArr,int start,int end) {
        if(start >= end) return;

        int pivot = start;
        int low = start + 1;
        int high = end;

        while(high >= low){
            while(low <= end && intArr[low] <= intArr[pivot]) low ++;
            while(high > start && intArr[high] >= intArr[pivot]) high--;

            if(low > high) swap(intArr, high, pivot);
            else swap(intArr, low, high);
        }

        quickSort(intArr, start, high-1);
        quickSort(intArr, high+1, end);
    }
    private static void swap(int[] intArr, int i, int j) {
        int temp = intArr[i];
        intArr[i] = intArr[j];
        intArr[j] = temp;
    }


}
