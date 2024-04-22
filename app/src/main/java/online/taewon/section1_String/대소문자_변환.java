package online.taewon.section1_String;

import java.util.Scanner;

public class 대소문자_변환 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();

        System.out.println(my_sol(str));
    }

    private static String my_sol(String str) {
        String result = "";
        for(char chr : str.toCharArray()){
            if(Character.isUpperCase(chr)){
                result += Character.toLowerCase(chr);
            }else{
                result += Character.toUpperCase(chr);
            }
        }

        return result;
    }

}
