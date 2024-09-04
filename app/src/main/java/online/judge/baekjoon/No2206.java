package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 못품
 */
public class No2206 {
    private static boolean[][] visited;
    private static boolean crush = false;
    private static int answer = Integer.MAX_VALUE;
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nm = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nm.nextToken());
        int m = Integer.parseInt(nm.nextToken());
        int[][] map = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        dfs(map, 0, 0, 1);

        if(answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);
    }

    private static void dfs(int[][] map, int x, int y, int cnt) {
        if(x == map.length-1 && y == map[0].length-1){
            answer = Math.min(answer, cnt);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx<map.length && ny < map[0].length && !visited[nx][ny]){
                if(map[nx][ny] == 1){
                    if(crush) continue;
                    crush = true;
                }
                visited[nx][ny] = true;
                dfs(map, nx, ny, cnt+1);
                visited[nx][ny] = false;
            }
        }

    }
}
