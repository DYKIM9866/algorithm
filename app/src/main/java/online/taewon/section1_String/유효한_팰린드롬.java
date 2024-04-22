package online.taewon.section1_String;

import java.util.Scanner;

public class 유효한_팰린드롬 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(mySol(str));
    }

    private static String mySol(String str) {
        String result = "";
        char[] charArray = str.toCharArray();
        int lt = 0;
        int rt = charArray.length-1;
        while(rt > lt){
            char left = charArray[lt];
            char right = charArray[rt];
            if(!Character.isAlphabetic(left)){
                lt++;
            }else if(!Character.isAlphabetic(right)){
                rt--;
            }else{
                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;
                lt++;
                rt--;
            }
        }

        if(str.equalsIgnoreCase(String.valueOf(charArray))){
            result = "YES";
        }else{
            result = "NO";
        }

        return result;
    }
}
