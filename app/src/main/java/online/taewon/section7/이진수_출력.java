package online.taewon.section7;

import java.util.Scanner;

public class 이진수_출력 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(mySol(n));
    }

    private static String mySol(int n) {
        if(n == 1) return "1";
        return mySol(n/2) + n%2;
    }
}
