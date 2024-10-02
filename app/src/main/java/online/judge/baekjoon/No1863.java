package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 스카이라인 쉬운거
 * 골드 4
 */
public class No1863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        while(n --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //비어있으면
            if(stack.isEmpty()){
                stack.push(y);
                continue;
            }else{
                //건물이 고도가 낮아짐
                while(!stack.isEmpty() && stack.peek() > y){
                    answer++;
                    stack.pop();
                }
                //같다면 넣을 필요 없이 넘겨줌
                if(!stack.isEmpty() && stack.peek() == y) continue;
            }
            //건물이 높아짐
            stack.push(y);
        }

        while (!stack.isEmpty()) {
            if(stack.peek() > 0){
                answer++;
            }
            stack.pop();
        }
        System.out.println(answer);
        
    }
}
