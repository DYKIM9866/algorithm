package online.taewon.section7;

import java.util.Scanner;

public class 팩토리얼 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(mySol(n));
    }

    private static int mySol(int n) {
        if(n == 1 || n == 0){
            return 1;
        }
        return n * mySol(n-1);
    }

}
