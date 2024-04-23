package online.taewon.section1_String;

import java.util.Scanner;

public class 숫자만_추출 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(mySol(str));
    }

    private static int mySol(String str) {
        String result = "";
        for(char chr : str.toCharArray()){
            if(!Character.isLetter(chr)){
                result += chr;
            }
        }

        return Integer.parseInt(result);
    }
}
