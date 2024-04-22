package online.taewon.section1_String;

import java.util.Scanner;

/**
 *  indexOf(), subString()
 */
public class 문장_속_단어 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(my_sol(str));
        System.out.println(classSol(str));
    }

    private static String my_sol(String str) {
        String result = "";
        String[] strArray = str.split(" ");
        int len = 0;

        for(String s : strArray){
            if(s.length() > len){
                len = s.length();
                result = s;
            }
        }

        return result;
    }

    private static String classSol(String str){
        String result = "";
        int m = Integer.MIN_VALUE,pos;
        while((pos=str.indexOf(' '))!= -1){
            String tmp = str.substring(0,pos);
            if(tmp.length() > m){
                m = tmp.length();
                result = tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length() > m) result = str;
        return result;
    }
}
