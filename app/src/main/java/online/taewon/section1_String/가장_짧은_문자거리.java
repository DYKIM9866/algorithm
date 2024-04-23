package online.taewon.section1_String;

import java.util.Scanner;

public class 가장_짧은_문자거리 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        char t = scan.next().charAt(0);

        for(int val : mySol(s,t)){
            System.out.print(val + " ");
        };
    }

    private static int[] mySol(String s, char t) {
        int p = 1000;
        int[] result = new int[s.length()];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == t){
                result[i] = 0;
                p = 0;
            }else{
                result[i] = ++p;
            }
        }
        p = 1000;
        for(int i=s.length()-1;i>=0;i--){
             if(s.charAt(i) == t){
                 result[i] = 0;
                 p = 0;
             }else{
                 result[i] = result[i] < ++p ?  result[i]:p;
             }
        }

        return result;
    }

}
