package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j+1] = line.charAt(j) - '0';
            }
        }

        bfs(n,map);

    }

    private static void bfs(int n, int[][] map) {
        List<Integer> answer = new ArrayList<>();
        int group = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};


        for(int i=1;i<=n;i++){
            for (int j = 1; j <= n; j++) {
                if(map[i][j] == 0) continue;
                Deque<int[]> que = new ArrayDeque<>();
                que.offer(new int[]{i,j});
                int cnt = 1;
                map[i][j] = 0;
                group++;

                while(!que.isEmpty()){
                    int[] xy = que.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = xy[0] + dx[k];
                        int ny = xy[1] + dy[k];
                        if(nx > 0 && ny > 0 && nx <= n && ny <= n && map[nx][ny] != 0){
                            map[nx][ny] = 0;
                            cnt++;
                            que.offer(new int[]{nx,ny});
                        }
                    }
                }

                answer.add(cnt);
            }
        }

        answer.sort(Comparator.naturalOrder());
        System.out.println(group);
        for(int x : answer) System.out.println(x);

    }
}
