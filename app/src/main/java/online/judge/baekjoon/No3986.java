package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 실버 4
 * 좋은 단어
 * 단어 쌍을 찾는 문제 교차되면 조건을 만족하지 못함
 * 스택에다가 담아서 쌍을 만나면 pop하는 방식으로 진행
 * 스택에 남아있다면 조건 불만족
 * 완료
 */
public class No3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.length() % 2 == 1) continue;
            Deque<Character> stack = new ArrayDeque<>();
            stack.push(str.charAt(0));
            for(int j=1;j<str.length();j++){
                if(!stack.isEmpty() && stack.peek() == str.charAt(j)) stack.pop();
                else stack.push(str.charAt(j));
            }

            if(stack.isEmpty()) answer++;
        }

        System.out.println(answer);
    }
}
