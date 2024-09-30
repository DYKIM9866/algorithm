package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 나이트의 이동
 * 실버1
 * 문제 해석
 * 1. 체스판에 나이트가 놓여져 있다.
 * 2. 나이트가 한번의 이동으로 이동할 수 있는 칸은 그림에 나와있다.
 * 3. 입력으로 현재 위치와 이동하려는 칸이 주어진다.
 * 4. 몇번 움직이면 칸에 도달할 수 있는지 계산해라
 *
 * 풀이
 * 1. 최단을 구해야 하기때문에 BFS 사용
 * 2. 입력을 받아서 BFS함수에 전달
 * 3. 만약 위치와 목표값이 같으면 바로 return
 * 4. 각 방향으로 보내면서 도달하면 현재 이동에서 +1 return
 * 5. 범위에 벗어나지 않으면 갔던 곳으로 체크해 주고 que에 담음
 */
public class No7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t --> 0){
            int n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
             st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());

            int move = bfs(sx,sy,fx,fy,n);
            System.out.println(move);

        }
    }


    private static int bfs(int sx, int sy, int fx, int fy, int n) {
        if(sx == fx && sy == fy) return 0;
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> que = new ArrayDeque<>();
        visited[sx][sy] = true;
        que.offer(new int[]{sx,sy,0});

        int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};

        while(!que.isEmpty()) {
            int[] xy = que.poll();
            for (int i = 0; i < 8; i++) {
                int nx = xy[0] + dx[i];
                int ny = xy[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n
                    || visited[nx][ny]) continue;

                if(nx == fx && ny == fy) return xy[2]+1;
                visited[nx][ny] = true;
                que.offer(new int[]{nx, ny, xy[2] + 1});
            }
        }

        return 0;
    }
}
