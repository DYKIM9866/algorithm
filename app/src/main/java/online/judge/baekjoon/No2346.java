package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 풍선 터뜨리기
 * 실버 3
 * 풍선과 값을 큐에 담아서 해당 풍선을 터뜨려 나오는 값만큼 큐를 이동시킴
 */
public class No2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] balloons = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            balloons[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        Deque<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            que.offer(new int[]{i+1, balloons[i]});
        }

        boolean flag = false;

        while(!que.isEmpty()){
            int[] balloon;
            if(!flag){
                balloon = que.poll();
            }else{
                balloon = que.pollLast();
            }
            sb.append(balloon[0]).append(' ');
            if(que.isEmpty()) break;
            if(balloon[1] > 0){
                for (int i = 1; i < balloon[1]; i++) {
                    que.offer(que.poll());
                }
                flag = false;
            }else{
                for (int i = 1; i < -1 * balloon[1]; i++) {
                    que.offerFirst(que.pollLast());
                }
                flag = true;
            }
        }


        System.out.println(sb);
    }
}
