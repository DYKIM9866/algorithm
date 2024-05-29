package online.taewon.section6_sorting_searching;

import java.util.Arrays;
import java.util.Scanner;

public class 중복_확인 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = scan.nextInt();
        }

        System.out.println(mySol(n,arr));
    }

    private static char mySol(int n, int[] arr) {
        int[] duple = new int[10_000_000];
        for(int x : arr){
            duple[x]++;
            if(duple[x] > 1){
                return 'D';
            }
        }

        return 'U';
    }
    private static char classSol(int n, int[] arr){
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            if(arr[i] == arr[i+1]) return 'D';
        }

        return 'U';
    }
}
