package online.taewon.section1_String;

import java.util.Scanner;

public class 특정_문자_뒤집기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(mySol(str));
    }

    private static String mySol(String str) {
        String result = "";
        int lt = 0;
        int rt = str.length()-1;
        char[] charArray = str.toCharArray();
        while(rt > lt) {
            if (!Character.isLetter(charArray[lt])) {
                lt++;
            } else if (!Character.isLetter(charArray[rt])) {
                rt--;
            } else {
                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;
                lt++;
                rt--;
            }
        }
        result = String.valueOf(charArray);

        return result;
    }
}
