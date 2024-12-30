package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 미로만들기
 * 골드 4
 */
public class No2665 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] room = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                room[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(room, n));

    }

    private static int bfs(int[][] room, int n) {

        Queue<int[]> que = new ArrayDeque<>();
        int[][] visited = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }
        que.offer(new int[]{0,0,0});


        while(!que.isEmpty()){
            int[] current = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                //방문 할 곳이 현재 검은 방보다 크면 갱신
                if(current[2] < visited[nx][ny]){
                    visited[nx][ny] = current[2];
                }else {
                    continue;
                }

                //다음 방문 할 방이 검은 방이면 1추가
                if(room[nx][ny] == 0){
                    que.offer(new int[]{nx,ny,current[2] + 1});
                }else{
                    que.offer(new int[]{nx,ny,current[2]});
                }
            }
        }

        return visited[n-1][n-1];
    }
}
