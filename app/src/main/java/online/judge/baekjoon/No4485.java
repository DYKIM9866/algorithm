package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 녹색 옷 입은 애가 젤다지?
 * 골드 4
 * 문제 해석
 * 1. 젤다의 전설 녹색 옷 입은 애는 링크이고 주인공이다.
 * 2. 젤다는 공주 이름이다.
 * 3. 0,0 에서 시작해 N-1,N-1 까지 가야하는 길에 도둑루피가 놓여져있다.
 * 4. 도둑루피는 오히려 루피를 잃는 루피이다.
 * 5. 링크가 상하좌우로 움직일 수 있을 때 가장 적게 루피를 잃는 경우를 구하라
 *
 * 문제 풀이
 * 1. 지점까지의 최소값을 구할 때는 BFS를 사용한다. (나는)
 * 2. N이 0일 때는 종료 조건이므로 true로 while문을 생성 후 종료 조건을 설정한다.
 * 3. bfs에서는 새로운 배열 route를 생성하고 최대값으로 초기화 한다.
 * 4. 만약 route[dx][dy]가 route[x][y] + map[dx][dy] 보다 클 경우 값을 넣어준다.
 * 5. 그니까 내가 '갈 곳'의 값과 내가 있는 곳의 값이 현재 '갈 곳'으로 가는 최소값보다 작으면 넣어준다는 소리임
 * 6. 코드설명은 코드에서 확인
 */
public class No4485 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        int idx = 1;
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            int[][] map = new int[n][n];

            //값 담기
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int minimumLost = bfs(map, n);

            answer.append(String.format("Problem %d: %d", idx++, minimumLost))
                    .append("\n");
        }

        System.out.println(answer);
    }

    private static int bfs(int[][] map, int n) {
        Queue<int[]> que = new ArrayDeque<>();

        //최소 값 담을 길 배열 생성 후 초기화
        int[][] route = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(route[i], Integer.MAX_VALUE);
        }
        //초기값 설정
        route[0][0] = map[0][0];
        que.offer(new int[]{0,0});


        while (!que.isEmpty()) {
            int[] poll = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                //갈 곳의 값 + 내가 있는 곳의 최소값이 갈 곳의 최소값 보다 작아야 함
                if(nx < 0 || ny < 0 || nx >= n || ny >= n
                        || route[nx][ny] <= map[nx][ny] + route[poll[0]][poll[1]])
                    continue;

                route[nx][ny] = map[nx][ny] + route[poll[0]][poll[1]];
                que.offer(new int[]{nx, ny});
            }
        }

        return route[n-1][n-1];
    }
}
