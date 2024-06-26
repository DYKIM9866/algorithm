package online.taewon.section6_sorting_searching;

import java.util.Scanner;

public class 버블_정렬 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        System.out.println(mySol(n,arr));
    }

    private static String mySol(int n, int[] arr) {
        String result = "";
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        for(int x : arr){
            result += x + " ";
        }

        return result;
    }
}
