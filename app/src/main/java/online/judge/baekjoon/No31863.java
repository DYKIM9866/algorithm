package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 골드 5
 * 내진 설계
 * 사방으로 뻗어나가는 문제이기 때문에 BFS로 풀이
 */
public class No31863 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        //지도와 건물이 무너졌는지 지진이 몇번 방문했는지 체크 할 배열 초기화
        char[][] grid = new char[n][m];
        int[][] check = new int[n][m];
        //빌딩 개수와 무너진 건물 개수 넣을 변수 초기화
        int building = 0;
        int crash = 0;

        Deque<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char chr = str.charAt(j);
                //진원지일 경우 -1(무너짐, 상관없음)으로 바꾸고 큐에 넣어줌
                if (chr == '@') {
                    check[i][j] = -1;
                    que.offer(new int[]{i, j, 2});
                }
                //빌딩 개수 세기
                if (chr == '*' || chr == '#') building++;
                grid[i][j] = chr;
            }
        }

        // 상 우 하 좌
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        /**
         * @: 진원지
         * .: 일반 도로
         * *: 내진 설계가 되어있지 않은 건물
         * #: 내진 설계가 되어있는 건물
         * |: 방파제
         */

        while (!que.isEmpty()) {
            int[] earthquake = que.poll();
            int x = earthquake[0];
            int y = earthquake[1];
            int time = earthquake[2];
            for (int i = 0; i < 4; i++) {
                //진원지일 경우 두번, 건물 무너짐 한번
                for (int j = 1; j <= time; j++) {
                    int nx = x + dx[i] * j;
                    int ny = y + dy[i] * j;
                    //지도를 벗어나거나 check가 -1일 경우 들어가지 않음
                    if (nx >= 0 && ny >= 0 && nx < n && ny < m
                            && check[nx][ny] != -1) {
                        char chr = grid[nx][ny];
                        //방파제 만나면 더이상 진행하지 않음
                        if (chr == '|') break;
                        else if (chr == '*') {
                            //내진 x 건물 만나면 무너뜨리고 큐에 여진 넣어줌
                            check[nx][ny] = -1;
                            crash++;
                            que.offer(new int[]{nx, ny, 1});
                        } else if (chr == '#') {
                            //내진 건물 만나면 몇번 왔었는지 체크하고 분기
                            if (check[nx][ny] == 1) {
                                check[nx][ny] = -1;
                                crash++;
                                que.offer(new int[]{nx, ny, 1});
                            } else {
                                check[nx][ny]++;
                            }
                        } else {
                            check[nx][ny] = -1;
                        }
                    }
                }
            }
        }

        System.out.println(crash + " " + (building - crash));
    }

}