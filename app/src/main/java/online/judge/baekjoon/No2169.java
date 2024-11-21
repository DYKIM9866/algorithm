package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로봇 조종하기
 * 골드 1
 *
 * 1. N x M 크기의 배열이 주어진다.
 * 2. 로봇은 좌, 우, 아래 로만 이동 가능하다.
 * 3. 한번 탐사한 지역은 다시 가지 않는다.
 * 4. 각 배열에는 탐사가치가 있다.
 * 5. 좌측 최상단에서 시작하여 우측 최하단으로 이동할 때, 이동한 경로의 탐사가치가 최대가 되도록 해라
 *
 * 문제 풀이
 * 1. bfs, dfs는 n, m 범위에 따라 불가능하다고 판단.
 * 2. 위로 올라가지 못하므로 한 줄씩 해결해야함
 * 3. 배열 위치에 올 수 있는 방법은 좌측에서 오거나 위에서 오거나 우측에서 오거나 세 가지이다.
 * 4. 하지만 좌측, 우측을 함께 생각할 필요는 없다.
 * 5. 첫 번째 줄은 좌측상단에서 시작하여 오른쪽으로만 갈 수 있으니 누적합 해준다.
 * 6. 다음 줄부터는 왼쪽으로 이동하는 경우 오른쪽으로 이동하는 경우를 따로 계산하여 최대가 되는 값을 넣어준다.
 * 7. 내려가는 위치를 찾는 과정이라고 생각하면 된다.
 */
public class No2169 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] mars = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mars[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];
        dp[0][0] = mars[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + mars[0][i];
        }

        int[][] temp = new int[2][m];

        for (int i = 1; i < n; i++) {
            //왼쪽
            temp[0][0] = dp[i-1][0] + mars[i][0];
            for (int j = 1; j < m; j++) {
                temp[0][j] = Math.max(dp[i-1][j], temp[0][j-1]) + mars[i][j];
            }

            //오른쪽
            temp[1][m-1] = dp[i-1][m-1] + mars[i][m-1];
            for (int j = m-2; j >= 0; j--) {
                temp[1][j] = Math.max(dp[i-1][j], temp[1][j+1]) + mars[i][j];
            }

            //합치기
            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }


        System.out.println(dp[n - 1][m - 1]);
    }
}
