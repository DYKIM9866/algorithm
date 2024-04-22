package online.taewon.section1_String;

import java.util.Scanner;

public class 중복문자제거 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(classSol(str));
    }

    private static String mySol(String str) {
        String result = "";
        for(char chr : str.toCharArray()){
            if(contain(result,chr)){
                continue;
            }
            result += chr;
        }
        return result;
    }

    private static boolean contain(String str, char chr) {
        boolean result = false;
        for(char c : str.toCharArray()){
            if(c == chr){
                return true;
            }
        }
        return result;
    }

    private static String classSol(String str){
        String result = "";

        for(int i=0;i<str.length();i++){
            if(str.indexOf(str.charAt(i)) == i){
                result += str.charAt(i);
            }
        }

        return result;
    }
}
