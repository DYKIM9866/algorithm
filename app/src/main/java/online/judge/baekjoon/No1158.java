package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 요세푸스 문제
 * 실버 4
 * 카운트 해주면서 해당 카운트에 닿으면 값을 빼주고 카운트 초기화
 */
public class No1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> que = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }

        int cnt = 0;
        while(!que.isEmpty()){
            cnt++;
            int x = que.poll();
            if(cnt == k){
                sb.append(x).append(", ");
                cnt = 0;
            }else{
                que.offer(x);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");

        System.out.println(sb);
    }
}
