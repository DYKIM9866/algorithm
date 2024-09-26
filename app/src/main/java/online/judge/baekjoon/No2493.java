package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 탑
 * 골드 5
 */
public class No2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> stack = new ArrayDeque<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                stack.push(new int[]{current, i+1});
                answer.append("0").append(' ');
            }else{
                while(!stack.isEmpty()){
                    int[] before = stack.peek();
                    if(current < before[0]){
                        answer.append(before[1]).append(' ');
                        break;
                    }

                    stack.pop();
                }
                if(stack.isEmpty()){
                    answer.append("0").append(' ');
                }
                stack.push(new int[]{current, i+1});
            }

        }

        System.out.println(answer);
    }
}
