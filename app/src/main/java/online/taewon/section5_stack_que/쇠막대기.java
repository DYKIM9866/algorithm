package online.taewon.section5_stack_que;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(mySol(str));
    }

    private static int mySol(String str) {
        int result = 0;
        char beforeChr = 'a';
        Stack<Character> stack = new Stack<>();

        for(char chr : str.toCharArray()){
            if(chr == '(') {
                stack.push(chr);
                beforeChr = '(';
            }
            else {
                if(beforeChr == '('){
                    stack.pop();
                    result += stack.size();
                }else{
                    stack.pop();
                    result += 1;
                }
                beforeChr = ')';
            }
        }
        return result;
    }

}
