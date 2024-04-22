package online.taewon.section1_String;

import java.util.Scanner;

public class 회문_문자열 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(mySol(str));
    }

    private static String mySol(String str) {
        String result = "YES";
        char[] charArray = str.toCharArray();
        for(int i=0;i<charArray.length/2;i++){
            char left = Character.toLowerCase(charArray[i]);
            char right = Character.toLowerCase(charArray[charArray.length-1-i]);
            if(left != right){
                result = "NO";
            }
        }
        return result;
    }
}
