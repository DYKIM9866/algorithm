package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 골드 5
 * 괄호의 값
 */
public class No2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        boolean flag = true;
        int answer = 0;
        int inner = 1;

        for(char chr : str.toCharArray()){
            if(chr == '(' || chr == '['){
                stack.push(chr);
            }else{
                if(stack.isEmpty() || !matchingPair(stack.peek(),chr)){
                    flag = false;
                    break;
                }
                stack.pop();
                if(chr == ')'){
                    if(stack.isEmpty()){
                        answer += 2;
                    }else{
                        inner += 2;
                    }
                }else{
                    if(stack.isEmpty()){
                        answer += 3;
                    }else{
                        inner += 3;
                    }
                }
            }
        }


        if(flag && stack.isEmpty()) System.out.println(answer);
        else System.out.println(0);
    }
    private static boolean matchingPair(Character pop, char tmp) {
        return (pop == '(' && tmp == ')') || (pop == '[' && tmp == ']');
    }
}
