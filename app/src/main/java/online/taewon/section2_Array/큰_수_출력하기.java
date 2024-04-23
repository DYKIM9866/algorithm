package online.taewon.section2_Array;

import java.util.Scanner;

public class 큰_수_출력하기 {
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
        for(int i=1;i<n;i++){
            if(intArr[i] > intArr[i-1]){
                result += intArr[i] + " ";
            }
        }
        result = intArr[0] + " " + result;
        return result;
    }

}
