package online.taewon.section6_sorting_searching;

import java.util.Scanner;

public class 선택_정렬 {
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
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j] < arr[i]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            result += arr[i] + " ";
        }
        result += arr[n-1];
        return result;
    }
}
