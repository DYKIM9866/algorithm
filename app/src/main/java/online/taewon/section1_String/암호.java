package online.taewon.section1_String;

import java.util.Scanner;

public class 암호 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String str = scan.next();

        System.out.println(mySol(n, str));
    }

    private static String mySol(int n, String str) {
        char[] result = new char[n];

        for(int i=0;i<n;i++){
            String temp = str.substring(0,7).replace("#","1").replace("*","0");
            result[i] = (char) Integer.parseInt(temp,2);
            str = str.substring(7);
        }

        return String.valueOf(result);
    }

}
