package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 실버 4
 * 균형잡힌 세상
 * 문자와 공백은 무시해주고 두가지 괄호가 나왔을 때만 반응한다.
 * 여는 괄호는 무조건 스택에 쌓아주고 닫는 괄호가 나왔을 경우 반응한다.
 * 닫는 괄호일 때 스택이 비어있다면 쌍이 맞지 않다.
 * 닫는 괄호일 때 최상위 값이 쌍이 맞는지 확인 한다.
 * 완료
 */
public class No4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;

            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;
            for(char tmp : str.toCharArray()){
                if(tmp == '(' || tmp == '[') stack.push(tmp);
                else if(tmp==')' || tmp == ']'){
                    if(stack.isEmpty() || !matchingPair(stack.pop(),tmp)){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }

    private static boolean matchingPair(Character pop, char tmp) {
        return (pop == '(' && tmp == ')') || (pop == '[' && tmp == ']');
    }
}
