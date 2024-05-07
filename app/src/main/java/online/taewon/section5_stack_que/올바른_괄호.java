package online.taewon.section5_stack_que;

import java.util.Scanner;
import java.util.Stack;

public class 올바른_괄호 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(mySol(str));
    }

    private static String mySol(String str) {
        String result = "YES";
        Stack<Character> stack = new Stack<>();

        for (char chr : str.toCharArray()) {
            if(chr == ')'){
                if(stack.isEmpty()) return "NO";
                if(stack.peek() != '(') return "NO";
                else stack.pop();
            }else{
                stack.push(chr);
            }
        }
        if(!stack.isEmpty()) return "NO";
        return result;
    }
}
