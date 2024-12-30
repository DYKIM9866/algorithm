package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 작업
 */
public class No2056 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //작업소요시간
        int[] time = new int[n + 1];
        //
        int[] select = new int[n + 1];
        // 선행작업 담기
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        //값 담기
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            time[i] = t;

            int cnt = Integer.parseInt(st.nextToken());

            for (int j = 0; j < cnt; j++) {
                int temp = Integer.parseInt(st.nextToken());

                list.get(temp).add(i);
                select[i]++;
            }
        }

        //
        Queue<Integer> que = new ArrayDeque<>();
        int[] result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            result[i] = time[i];
            // 날 가리키는 정점이 없다면 즉, 맨 끝값이라면
            if(select[i] == 0){
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int cur = que.poll();

            for(int next : list.get(cur)){
                select[next]--;

                result[next] = Math.max(result[next], result[cur] + time[next]);

                if(select[next] == 0){
                    que.offer(next);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, result[i]);
        }
        System.out.println(answer);

    }
}
