package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 양치기 꿍
 * 실버 1
 * 문제 해석
 * 1. 울타리로 쌓여 있는 곳에 늑대와 양이 주어진다.
 * 2. 양이 늑대보다 많으면 늑대가 양을 다 잡아먹는다.
 * 3. 그 외의 경우는 늑대가 양을 다 잡아 먹는다.
 * 4. 마지막에 남는 양과 늑대를 출력해라
 *
 * 풀이
 * 1. 울타리에 쌓여있지 않을 경우의 늑대와 양은 주어지지 않는다.
 * 2. 양이든 늑대든 발견했을 경우 큐에 담아 울타리를 만날 때 까지 개체의 수를 세어준다.
 * 3. 센 후에는 !로 바꾸어준다.
 * 4. 마지막 숫자를 비교하여 양이 늑대보다 많을 경우는 양만 외의 경우는 늑대만 추가해준다.
 */
public class No3187 {

    static int v = 0;
    static int k = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer rc = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(rc.nextToken());
        int c = Integer.parseInt(rc.nextToken());

        char[][] map = new char[r][c];
        for (int i = 0; i < r; i++) {
            char[] chrArr= br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = chrArr[j];
            }
        }
        int sheep = 0;
        int wolf = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(map[i][j] == 'v' || map[i][j] == 'k'){
                    v = 0;
                    k = 0;
                    findVK(i,j,r,c,map);

                    if(k > v) sheep += k;
                    else wolf += v;
                }
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    private static void findVK(int i, int j,int r,int c, char[][] map) {
        Deque<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{i,j});
        if(map[i][j] == 'v') v++;
        if(map[i][j] == 'k') k++;
        map[i][j] = '!';

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!que.isEmpty()){
            int[] xy = que.poll();
            int x = xy[0];
            int y = xy[1];
            for (int l = 0; l < 4; l++) {
                int nx = x + dx[l];
                int ny = y + dy[l];
                if(nx < 0 || ny < 0 || nx >= r || ny >= c
                || map[nx][ny] == '#' || map[nx][ny] == '!') continue;
                if(map[nx][ny] == 'v') v++;
                if(map[nx][ny] == 'k') k++;
                map[nx][ny] = '!';
                que.offer(new int[]{nx, ny});
            }
        }

    }

}
