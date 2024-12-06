package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 구슬 탈출
 * 골드 1
 *
 * 문제 해석
 * 1. 직사각형 보드에 빨간 구슬 파란 구슬이 있다.
 * 2. 빨간 구슬을 구멍으로 빼내려고 한다.
 * 3. 중력을 사용해서 기울여서 빼낼 수 있다.
 * 4. 파란 구슬이 나오거나 둘이 같이 나오면 안된다.
 * 5. 10번 이하로 가능하면 1을 출력 안된다면 0을 출력한다.
 *
 * 문제 풀이
 * 1. BFS사용
 * 2. 시간제한은 2초 횟수도 10번 이내로 한정되어있기 때문에 자원은 생각하지 않았다.
 * 3. 파란 구슬이 나오면 안되므로 파란 구슬을 우선적으로 생각한다.
 * 4. 각 구슬을 각 방향으로 #을 만나거나 구멍을 만날 때까지 굴려준다.
 * 5. 파란 구슬이 구멍을 만났다면 넘어간다.
 * 6. 빨간 구슬이 구멍을 만났다면 1을 출력한다.
 * 7. 방문한적이 없는 곳에 도착하면 방문에 넣어주고 QUEUE에 넣어준다.
 */
public class No13459 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];

        int[] rLocation = null;
        int[] bLocation = null;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if (c == 'R') rLocation = new int[]{i, j};
                if (c == 'B') bLocation = new int[]{i, j};
                map[i][j] = c;
            }
        }

        System.out.println(bfs(n, m, map, rLocation, bLocation));
    }

    private static int bfs(int n, int m, char[][] map,
                            int[] rLocation, int[] bLocation) {
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][][][] visited = new boolean[n][m][n][m];

        //초기값
        que.offer(new int[]{rLocation[0], rLocation[1], bLocation[0], bLocation[1], 1});
        visited[rLocation[0]][rLocation[1]][bLocation[0]][bLocation[1]] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int rx = cur[0], ry = cur[1];
            int bx = cur[2], by = cur[3];
            int depth = cur[4];

            if (depth > 10) return 0;

            for (int i = 0; i < 4; i++) {
                int[] nextR = moveBead(rx, ry, dx[i], dy[i], map);
                int[] nextB = moveBead(bx, by, dx[i], dy[i], map);

                // B가 구멍에 들어가면 실패
                if (map[nextB[0]][nextB[1]] == 'O') continue;

                // R만 구멍에 들어가면 성공
                if (map[nextR[0]][nextR[1]] == 'O') return 1;

                // R과 B가 같은 위치에 있으면 더 많이 움직인 쪽을 뒤로
                if (nextR[0] == nextB[0] && nextR[1] == nextB[1]) {
                    if (nextR[2] > nextB[2]) {
                        nextR[0] -= dx[i];
                        nextR[1] -= dy[i];
                    } else {
                        nextB[0] -= dx[i];
                        nextB[1] -= dy[i];
                    }
                }

                // 방문하지 않은 상태라면 큐에 추가
                if (!visited[nextR[0]][nextR[1]][nextB[0]][nextB[1]]) {
                    visited[nextR[0]][nextR[1]][nextB[0]][nextB[1]] = true;
                    que.offer(new int[]{nextR[0], nextR[1], nextB[0], nextB[1], depth + 1});
                }
            }
        }
        return 0; // 10번 내에 성공하지 못하면 실패
    }

    private static int[] moveBead(int x, int y, int dx, int dy, char[][] map) {
        int distance = 0;
        while (map[x + dx][y + dy] != '#' && map[x][y] != 'O') {
            x += dx;
            y += dy;
            distance++;
        }
        return new int[]{x, y, distance};
    }
}

