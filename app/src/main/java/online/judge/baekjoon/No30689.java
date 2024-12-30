package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 미로 보수
 * 골드 3
 *
 * 문제 해석
 * 1. N x M 크기의 미로가 있다.
 * 2. 각 칸의 아래에 방향이 있고 그 방향으로만 움직일 수 있다.
 * 3. 미로밖으로 나가게 되면 탈출이다.
 * 4. 방향이 루프를 만들면 그 안에 비용이 최소가 되도록 점프대를 설치해서 미로를 탈출하게 한다.
 * 5. 어느 곳에서 출발해도 탈출이 가능하도록 점프대 설치 최소 비용을 출력해라.
 *
 * 문제 풀이
 * 1. DFS 문제라고 판단했다.
 * 2. 각 좌표 반복문을 실행한다.
 * 3. 방문 이력이 없으면 dfs알고리즘을 탄다.
 * 4. 스택에 초기 출발지점을 넣어주고 지나온 길을 저장할 리스트를 선언한다.
 * 5. 미로를 벗어났거나 이미 방문완료 했던 곳에 닿으면 지나간 리스트를 비우고 방문 완료한다.
 * 6. 만약 지나왔던 길을 다시 만나면 루프가 있는 것으로 판단하고 최솟값을 계산하여 return 한다.
 * 7. 0은 비방문, 1은 방문중 2는 방문 완료
 *     0일 경우 값을 담고 visited를 1로변경
 *     1일 경우 사이클이 발생한 것이므로 사이클에서 최솟값을 찾아 점프대 설치 후 visited 2로 변경
 *     2일 경우 모두 탈출 가능한 것이므로 진행 중이던 것들 전부 2로 변경
 *
 * ** 중요한 점은 이전경로를 탐색해서 min값을 찾게 되면 실패한다. 그 이유는 이전경로가 모두 사이클이 되지는 않기 때문이다.
 */
public class No30689 {
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        int[][] cost = new int[n][m];

        //지도 담기
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        //비용 담기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //돌면서 dfs
        int answer = 0;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0) {
                    answer += dfs(i, j, n, m, map, cost, visited);
                }
            }
        }

        System.out.println(answer);
    }

    private static int dfs(int i, int j, int n, int m, char[][] map, int[][] cost, int[][] visited) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{i,j});

        List<int[]> befores = new ArrayList<>();

        while (!stack.isEmpty()){
            int[] pop = stack.pop();
            int x = pop[0];
            int y = pop[1];
            int direction = getDirection(map[x][y]);
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            //밖을 나가거나 2를 만나면 현재 좌표 포함 이전 값들 모두 2로 변경
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] == 2){
                visited[x][y] = 2;
                for(int[] before : befores){
                    visited[before[0]][before[1]] = 2;
                }
                befores.clear();
            // 1을 만나면 사이클 내에서 최소값을 찾아준다. 이전 경로에서 찾으면 안됨
            }else if (visited[nx][ny] == 1){
                int min = cost[x][y];
                int minX = nx;
                int minY = ny;
                while(minX != x || minY != y){
                    min = Math.min(min, cost[minX][minY]);
                    int d = getDirection(map[minX][minY]);
                    minX += dx[d];
                    minY += dy[d];
                }

                visited[x][y] = 2;
                for(int[] before : befores){
                    visited[before[0]][before[1]] = 2;
                }

                return min;
            }else{
                stack.push(new int[]{nx, ny});

                visited[x][y] = 1;
                befores.add(new int[]{x,y});
            }
        }

        return 0;
    }

    private static int getDirection(char d) {
        int x = 0;
        switch (d) {
            case 'U': return 0;
            case 'R': return 1;
            case 'D': return 2;
            default: return 3;
        }
    }


}
