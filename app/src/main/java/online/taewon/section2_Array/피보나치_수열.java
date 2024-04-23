package online.taewon.section2_Array;

import java.util.Scanner;

public class 피보나치_수열 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(mySol(n));
    }

    private static String mySol(int n) {
        String result = "";
        int[] intArr = new int[n];
        intArr[0] = 1;
        intArr[1] = 1;
        for(int i=2;i<n;i++){
            intArr[i] = intArr[i-1] + intArr[i-2];
        }

        for(int i=0;i<intArr.length;i++){
            result += intArr[i] + " ";
        }

        return result;
    }

}
