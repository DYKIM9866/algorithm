package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 바이러스
 * 실버 3
 * 문제 해석
 * 1. 어떤 컴퓨터가 감염되면 연결된 컴퓨터는 모두 감염된다.
 * 2. 입력으로 컴퓨터의 수와 연결 수 그리고 연결되어있는 짝이 들어온다.
 * 3. 1번이 감염될 때 몇개의 컴퓨터가 더 감염이 되는지 출력해라
 *
 * 풀이
 * 1. dfs, bfs 다 가능한 문제
 * 2. 풀이 방식도 동일하다.
 * 3. 방향이 없는 양방향 연결이므로 연결을 담아줄때 양쪽 다 담아줘야 한다.
 * 4. 초기값 1을 스택, 큐에 넣고 연결된 값들을 조사하여 이미 감염이 됐다면 넘어가고 아니라면
 * 감염시키고 다시 넣는다.
 */
public class No2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Integer>[] network = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            network[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int nextCom = Integer.parseInt(st.nextToken());

            network[com].add(nextCom);
            network[nextCom].add(com);
        }

        System.out.println(bfs(n,network));
//        System.out.println(dfs(n,network));

    }

    private static int dfs(int n, List<Integer>[] network) {
        boolean[] infection = new boolean[n+1];
        Deque<Integer> stack = new ArrayDeque<>();
        //초기값
        infection[1] = true;
        stack.push(1);

        int cnt = 0;

        while(!stack.isEmpty()){
            int current = stack.pop();
            for(int next : network[current]){
                if(!infection[next]){
                    cnt++;
                    infection[next] = true;
                    stack.push(next);
                }
            }
        }

        return cnt;
    }


    private static int bfs(int n, List<Integer>[] network) {
        boolean[] infection = new boolean[n+1];
        Deque<Integer> que = new ArrayDeque<>();
        //초기값
        infection[1] = true;
        que.offer(1);

        //1번은 감염되기에
        int cnt = 0;
        while(!que.isEmpty()){
            int current = que.poll();
            List<Integer> currentNet = network[current];
            for (int i = 0; i < currentNet.size(); i++) {
                int next = currentNet.get(i);
                if(!infection[next]){
                    cnt++;
                    infection[next] = true;
                    que.offer(next);
                }
            }
        }
        return cnt;
    }
}
