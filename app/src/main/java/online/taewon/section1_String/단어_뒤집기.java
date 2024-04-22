package online.taewon.section1_String;

import java.util.Scanner;

public class 단어_뒤집기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String[] strArray = new String[n];
        for(int i=0;i<strArray.length;i++){
            strArray[i] = scan.next();
        }

        for(String str : mySol2(strArray)){
            System.out.println(str);
        }
    }

    private static String[] mySol(String[] strArray) {
        String[] resultArray = new String[strArray.length];
        for(int i=0;i<strArray.length;i++){
            for(char chr : strArray[i].toCharArray()){
                resultArray[i] = chr + (resultArray[i] != null ? resultArray[i]:"");
            }
        }
        return resultArray;
    }
    private static String[] mySol2(String[] strArray){
        String[] resultArray = new String[strArray.length];

        for(int i=0;i<strArray.length;i++){
            StringBuilder sb = new StringBuilder(strArray[i]);
            resultArray[i] = sb.reverse().toString();
        }

        return resultArray;
    }
}
