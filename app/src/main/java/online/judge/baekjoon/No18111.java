package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 마인크래프트
 * 실버 2
 * 문제 해석
 * 1. 집을 짓기 위해 땅 고르기 할 것
 * 2. NxM의 크기의 땅을 정했고 땅고르기를 하려고 한다.
 * 3. 좌표의 땅 높이가 주어진다.
 * 4. 땅 높이가 높다면 캐서 저장할 수 있다. 2초 소요
 * 5. 땅이 낮다면 가지고 있는 땅을 넣어 메울 수 있다. 1초 소요
 * 6. 입력으로
 *  3 4 99 (N,M, 가지고 있는 블록의 수)
 *  0 0 0 0 (좌표값 들)
 *  0 0 0 0
 *  0 0 0 1
 * 7. 땅이 평평해지는 데 걸리는 최소시간과 높이를 출력해라
 */
public class No18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
