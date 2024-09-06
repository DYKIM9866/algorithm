package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 골드 3
 * 드래곤 커브
 * 미완
 */
public class No15685 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[][] grid = new int[101][101];
            int answer = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());


            }

            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    if(grid[i][j] == 1 && grid[i+1][j] == 1
                    && grid[i][j+1] == 1 && grid[i+1][j+1] == 1) answer++;
                }
            }

            System.out.println(answer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
