package online.judge.baekjoon;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 숨바꼭질
 * 실버 1
 */
public class No1697 {
    static final int[] move = {-1, 1, 2};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        System.out.println(bfs(n,k));
    }

    private static int bfs(int n, int k) {

        int[] map = new int[100_001];
        boolean[] visited = new boolean[100_001];
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(n);
        visited[n] = true;
        while(!que.isEmpty()){
            if(visited[k]) break;
            int current = que.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if(i == 2) nx = current*2;
                else nx = current + move[i];

                if(nx < 0 || nx >= 100_001 || visited[nx]) continue;
                map[nx] = map[current] + 1;
                visited[nx] = true;
                que.offer(nx);
            }
        }

        return map[k];
    }
}
