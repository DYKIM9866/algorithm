package online.taewon.section6_sorting_searching;

import java.beans.beancontext.BeanContext;
import java.util.Scanner;

public class 삽입_정렬 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }

        System.out.println(mySol(n,arr));
    }
    private static String mySol(int n, int[] arr) {
        String result = "";
        for(int i=1;i<n;i++){
            int tmp = arr[i], j;
            for(j=i-1;j>=0;j--){
                if(arr[j] > tmp) arr[j+1] = arr[j];
                else break;
            }
            arr[j+1] = tmp;
        }

        for(int x : arr){
            result += x + " ";
        }
        return result;
    }
}
