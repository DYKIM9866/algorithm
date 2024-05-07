package online.taewon.section5_stack_que;

import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(mySol(str));
    }

    private static String mySol(String str) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for(char chr : str.toCharArray()){
            if(chr == ')'){
                while(stack.pop() != '(');
            }else{
                stack.push(chr);
            }
        }
        for(char chr : stack){
            result += chr;
        }
        return result;
    }
}
