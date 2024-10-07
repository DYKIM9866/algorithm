package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 녹색 옷 입은 애가 젤다지?
 * 골드 4
 */
public class No4485 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int cnt = 1;

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] cave = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cave[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int x = bfs(n, cave);

            answer.append(String.format("Problem %d: %d", cnt++, x))
                    .append("\n");

        }
        System.out.println(answer);
    }

    private static int bfs(int n, int[][] cave) {
        int[][] answerCave = new int[n][n];
        Queue<int[]> que = new ArrayDeque<>();

        //초기 값 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answerCave[i][j] = Integer.MAX_VALUE;
            }
        }
        answerCave[0][0] = cave[0][0];
        que.offer(new int[]{0,0});

        while(!que.isEmpty()){
            int[] current = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(answerCave[nx][ny] > answerCave[current[0]][current[1]] + cave[nx][ny]){
                    answerCave[nx][ny] = answerCave[current[0]][current[1]] + cave[nx][ny];
                    que.offer(new int[]{nx,ny});
                }
            }

        }


        return answerCave[n-1][n-1];
    }
}
