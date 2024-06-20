package online.taewon.section8_dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 토마토 {
    static Deque<Point> que = new ArrayDeque<>();

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            int m = scan.nextInt();
            int n = scan.nextInt();

            int[][] box = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int value = scan.nextInt();
                    box[i][j] = value;
                    if(value == 1){
                        que.offer(new Point(i, j));
                    }
                }
            }
            int result = sol(n, m, box);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(box[i][j] == 0) result = 0;
                }
            }

            System.out.println(result - 1);

        }
    }

    private static int sol(int n, int m, int[][] box) {
        int result = Integer.MIN_VALUE;

        int[] roadX = {0,1,0,-1};
        int[] roadY = {1,0,-1,0};

        while (!que.isEmpty()) {
            Point point = que.poll();
            if(result < box[point.x][point.y]) result = box[point.x][point.y];
            for (int i = 0; i < 4; i++) {
                int dx = point.x + roadX[i];
                int dy = point.y + roadY[i];
                if (dx >= 0 && dy >= 0 && dx < n && dy < m && box[dx][dy] == 0) {
                    box[dx][dy] = box[point.x][point.y] + 1;
                    que.offer(new Point(dx, dy));
                }
            }
        }

        return result;
    }

    private static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
