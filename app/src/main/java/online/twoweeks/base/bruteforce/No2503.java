package online.twoweeks.base.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준
 * 숫자야구
 * 실버3
 */
public class No2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] game = new int[n][3];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            game[i][0] = Integer.parseInt(st.nextToken());
            game[i][1] = Integer.parseInt(st.nextToken());
            game[i][2] = Integer.parseInt(st.nextToken());
        }

        System.out.println(expect(n, game));
    }

    private static int expect(int n, int[][] game) {
        int result = 0;

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    if(i==j || j==k || i==k) continue;
                    if (j == 0 || k == 0) continue;

                    int cnt = 0;
                    for (int[] hint : game) {
                        int number = hint[0];
                        int strike = hint[1];
                        int ball = hint[2];

                        int n100 = number / 100;
                        int n10 = (number % 100) / 10;
                        int n1 = (number % 100) % 10;

                        int ballCount = 0;
                        int strikeCount = 0;

                        if(i == n100) strikeCount++;
                        if(j == n10) strikeCount++;
                        if(k == n1) strikeCount++;
                        if(i == n10 || i==n1) ballCount++;
                        if(j == n100 || j==n1) ballCount++;
                        if(k == n100 || k==n10) ballCount++;

                        if(ball == ballCount && strike == strikeCount) cnt++;

                    }
                    if(cnt == n){
                        result++;
//                        System.out.println(i+""+j+""+k);
                    }

                }
            }
        }

        return result;
    }
}
