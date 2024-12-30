package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 스타트 택시
 */
public class No19238 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};


    static int n;
    static int m;
    static int fuel;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken())-1;
        int startY = Integer.parseInt(st.nextToken())-1;

        for (int i = 2; i < m+2; i++) {
            st = new StringTokenizer(br.readLine());
            int x  = Integer.parseInt(st.nextToken())-1;
            int y  = Integer.parseInt(st.nextToken())-1;
            int ax  = Integer.parseInt(st.nextToken())-1;
            int ay  = Integer.parseInt(st.nextToken())-1;

            map[x][y] = i;
            map[ax][ay] = n * n + i;
        }

        for (int i = 0; i < m; i++) {
            //승객 찾기
            int[] customer = findCustomer(startX, startY);
            if(fuel == -1) {
                break;
            }

            //목적지 가기
            if(fuel == -1){
                break;
            }

        }

        System.out.println(fuel);
    }

    private static int[] findCustomer(int startX, int startY) {
        Queue<int[]> findQue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        findQue.offer(new int[]{startX, startY, 0, fuel});
        visited[startX][startY] = true;

        int dis = Integer.MAX_VALUE;
        int remainFuel = 0;
        int customerX = n;
        int customerY = n;

        while (!findQue.isEmpty()) {
            int[] cur = findQue.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            int f = cur[3];

            if (dis < d) continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n
                        || map[nx][ny] == 1 || visited[nx][ny] ||
                        f - 1 < 0) continue;

                if (map[nx][ny] > 1 && map[nx][ny] < n * n) {
                    if (dis > d + 1) {
                        dis = d + 1;
                        customerX = nx;
                        customerY = ny;
                        remainFuel = f - 1;
                    } else if (dis == d + 1) {
                        if (customerX > nx ||
                                (customerX == nx && customerY > ny)) {
                            customerX = nx;
                            customerY = ny;
                            remainFuel = f - 1;
                        }
                    }
                }
                visited[nx][ny] = true;
            }
        }
        return null;
    }
}
