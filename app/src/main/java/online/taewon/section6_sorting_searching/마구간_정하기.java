package online.taewon.section6_sorting_searching;

import java.util.Scanner;

public class 마구간_정하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int c = scan.nextInt();
        int[] grid = new int[n];
        for (int i = 0; i < n; i++) {
            grid[i] = scan.nextInt();
        }
//        mySol(n,c,grid);
        System.out.println(mySol(n,c,grid));
    }

    private static int mySol(int n, int c, int[] grid) {
        int result = 1;
        mergeSort(grid, 0, n-1);

        int lt = 1;
        int rt = grid[n-1];
        while(lt <= rt){
            int mid = (lt+rt)/2;
            int val = isRight(grid, mid);
            if(val >= c) {
                result = mid;
                lt = mid+1;
            }else{
                rt = mid-1;
            }
        }

        return result;
    }

    private static int isRight(int[] grid, int mid) {
        int ma = grid[0];
        int count = 1;
        for (int i = 1; i < grid.length; i++) {
            if(grid[i]-ma >= mid){
                count++;
                ma = grid[i];
            }
        }

        return count;
    }

    private static void mergeSort(int[] grid, int start, int end) {
        if(start >= end) return;

        int mid = (start + end)/2;
        mergeSort(grid, start, mid);
        mergeSort(grid, mid+1, end);

        merge(grid, start, mid, end);
    }

    private static void merge(int[] grid, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];

        int left = start;
        int right = mid+1;
        int idx = 0;

        while(left <= mid && right<=end){
            if(grid[left] <= grid[right]) temp[idx++] = grid[left++];
            else temp[idx++] = grid[right++];
        }
        while(left <= mid) temp[idx++] = grid[left++];
        while(right <= end) temp[idx++] = grid[right++];

        for (int i = start; i <= end; i++) {
            grid[i] = temp[i-start];
        }
    }
}
