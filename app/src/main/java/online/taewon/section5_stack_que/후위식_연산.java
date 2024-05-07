package online.taewon.section5_stack_que;

import java.util.Scanner;
import java.util.Stack;

public class 후위식_연산 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(mySol(str));
    }

    private static int mySol(String str) {
        Stack<Integer> stack = new Stack<>();

        for(char chr : str.toCharArray()){
            int a = stack.pop();
            int b = stack.pop();
            if(chr == '+'){
                stack.push(b+a);
                continue;
            }else if(chr == '-'){
                stack.push(b-a);
                continue;
            }else if(chr == '*'){
                stack.push(b*a);
                continue;
            }else if(chr == '/'){
                stack.push(b/a);
                continue;
            }
            stack.push(chr - 48);
        }

        return stack.pop();
    }
}
