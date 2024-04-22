package online.taewon.section1_String;

import java.util.Scanner;

public class 문자_찾기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char chr = scan.nextLine().charAt(0);

        System.out.println(my_sol(str, chr));
    }
    private static int my_sol(String str, char chr){
        int result = 0;
        for(char c : str.toCharArray()){
            if(Character.toLowerCase(c) == Character.toLowerCase(chr)){
                result++;
            }
        }
        return result;
    }
}
