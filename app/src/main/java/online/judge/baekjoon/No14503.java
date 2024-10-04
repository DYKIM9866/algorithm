package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 로봇 청소기
 * 골드 5
 */
public class No14503 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int direct = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(r, c, direct, map));

    }

    private static int dfs(int r, int c, int direct, int[][] map) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{r,c,direct});
        int answer = 1;
        map[r][c] = 2;

        while(!stack.isEmpty()) {
            int[] current = stack.pop();
            int d = current[2];
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                //시계 반대방향
                d = (d + 3) % 4;

                int nx = current[0] + dx[d];
                int ny = current[1] + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] == 0) {
                    answer++;
                    map[nx][ny] = 2;
                    stack.push(new int[]{nx, ny, d});
                    flag = true;
                    break;
                }
            }

            if (flag) continue;

            d = (current[2] + 2) % 4;
            int backX = current[0] + dx[d];
            int backY = current[1] + dy[d];
            if (backX >= 0 && backY >= 0 && backX < n && backY < m
                    && map[backX][backY] != 1) {
                stack.push(new int[]{backX, backY, current[2]});
            }
        }

        return answer;
    }
}
