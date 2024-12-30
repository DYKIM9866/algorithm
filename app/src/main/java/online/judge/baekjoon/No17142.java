package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 연구소 3
 * 골드 3
 */
public class No17142 {

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int answer = Integer.MAX_VALUE;
    static int n, m;
    static int[][] map;
    static List<int[]> virus;
    static boolean[] virusSelect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        virus = new ArrayList<>();

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());

                if(v == 2){
                    virus.add(new int[]{i,j});
                }

                map[i][j] = v;
            }
        }

        virusSelect = new boolean[virus.size()];

        dfs(0,0);

        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void dfs(int depth, int idx) {
        if(depth == m){
            int state = bfs();

            if(state == -1) return;

            answer = Math.min(answer, state);

            return;
        }
        for(int i=idx;i< virus.size();i++){
            if(!virusSelect[i]){
                virusSelect[i] = true;
                dfs(depth+1, i+1);
                virusSelect[i] = false;
            }
        }
    }

    private static int bfs() {
        Queue<int[]> que = new ArrayDeque<>();
        int[][] visited = new int[n][n];

        //초기 값 설정
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < virus.size(); i++) {
            if(virusSelect[i]){
                int[] active = virus.get(i);
                visited[active[0]][active[1]] = 0;
                que.offer(new int[]{active[0],active[1],0});
            }
        }

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int d = cur[2];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n ||
                    map[nx][ny] == 1 || visited[nx][ny] <= d+1) continue;

                if(map[nx][ny] == 2 && visited[nx][ny] == Integer.MAX_VALUE){
                    visited[nx][ny] = d;
                    que.offer(new int[]{nx,ny,d});
                }else if(map[nx][ny] == 0){
                    visited[nx][ny] = d+1;
                    que.offer(new int[]{nx,ny,d+1});
                }
            }
        }

        int returnValue = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if((map[i][j] == 0 || map[i][j] == 2)
                        && visited[i][j] == Integer.MAX_VALUE){
                    return -1;
                }

                returnValue = Math.max(returnValue, visited[i][j]);
            }
        }
        return returnValue;
    }
}
