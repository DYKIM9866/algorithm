package online.taewon.section8_dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 섬나라_아일랜드 {
    static int n, result;
    static int[][] map,check;

    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int result = 0;
            n = scan.nextInt();
            map = new int[n][n];
            check = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = scan.nextInt();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(map[i][j] == 1){
                        result++;
//                        dfs(i, j);
                        bfs(i,j);
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static void bfs(int x, int y) {
        map[x][y] = 2;

        Deque<Point> que = new ArrayDeque<>();
        que.offer(new Point(x, y));

        while (!que.isEmpty()) {
            Point point = que.poll();
            for (int i = 0; i < 8; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny] == 1){
                    map[nx][ny] = 2;
                    que.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static void dfs(int x, int y) {
        map[x][y] = 2;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny] == 1){
                map[nx][ny] = 2;
                dfs(nx, ny);
            }
        }
    }


}

class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
