package online.taewon.section1_String;

import java.util.Scanner;

public class 문자열_압축 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(mySol(str));
    }

    private static String mySol(String str) {
        String result = "";
        for(int i=0;i<str.length();i++){
            int count = 0;
            for(int j=i;j<str.length();j++){
                if(str.charAt(i) == str.charAt(j)){
                    count++;
                }else{
                    break;
                }
            }
            if(count > 1){
                result += String.valueOf(str.charAt(i)) + count;
            }else{
                result += str.charAt(i);
            }
            i += count-1;
        }

        return result;
    }
}
