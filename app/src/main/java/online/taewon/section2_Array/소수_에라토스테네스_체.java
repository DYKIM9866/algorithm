package online.taewon.section2_Array;

import java.util.Scanner;

public class 소수_에라토스테네스_체 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        System.out.println(mySol(n));
        System.out.println(classSol(n));
    }

    private static int mySol(int n) {
        int result = 0;
        int[] intArr = new int[n+1];
        intArr[0] = 1;
        intArr[1] = 1;
        for(int i=2;i<=n;i++){
            if(intArr[i] == 1){
                continue;
            }
            for(int j=i*2;j<=n;j+=i){
                intArr[j] = 1;
            }
        }

        for(int x : intArr){
            if(x == 0) result++;
        }

        return result;
    }

    private static int classSol(int n){
        int result = 0;
        int[] intArr = new int[n+1];
        for(int i=2;i<=n;i++){
            if(intArr[i] == 0){
                result++;
                for(int j=i;j<=n;j+=i){
                    intArr[j] = 1;
                }
            }
        }
        return result;
    }
}
