package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Bucket Brigade
 * 실버 4
 */
public class No17198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[10][10];

        int x=0;
        int y=0;
        for (int i = 0; i < 10; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < 10; j++) {
                char chr = strArr[j].charAt(0);
                map[i][j] = chr;
                if(chr == 'B'){
                    x=i;
                    y=j;
                }
            }
        }

        System.out.println(bfs(x,y,map));
    }

    private static int bfs(int x, int y,  char[][] map) {
        int[][] visited = new int[10][10];
        Deque<int[]> que = new ArrayDeque<>();
        //초기값
        visited[x][y] = -1;
        que.offer(new int[]{x,y,0});

        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while(!que.isEmpty()){
            int[] current = que.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= 10 || ny >= 10
                    || visited[nx][ny] != 0 || map[nx][ny] == 'R'
                    || map[nx][ny] == 'B') continue;

                if(map[nx][ny] == 'L'){
                    return visited[current[0]][current[1]];
                }
                visited[nx][ny] = current[2]+1;
                que.offer(new int[]{nx,ny,current[2]+1});
            }
        }

        return 0;
    }
}
