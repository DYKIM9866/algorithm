package online.taewon.section2_Array;

import java.util.Scanner;

public class 뒤집은_소수 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] intArr = new int[n];
        for(int i=0;i<n;i++){
            intArr[i] = scan.nextInt();
        }

        System.out.println(mySol(n, intArr));
    }

    private static String mySol(int n, int[] intArr) {
        String result = "";
        for(int x : intArr){
            StringBuilder sb = new StringBuilder().append(x);
            x = Integer.parseInt(String.valueOf(sb.reverse()));
            if(isPrime(x)){
                result += x + " ";
            }
        }
        return result;
    }
    private static boolean isPrime(int n){
        boolean result = true;
        if(n == 1) return false;

        for(int i=2;i<n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return result;
    }
}
