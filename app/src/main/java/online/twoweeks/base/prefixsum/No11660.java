package online.twoweeks.base.prefixsum;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 백준
 * 구간 합 구하기 5
 */
public class No11660 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer nm = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(nm.nextToken());
            int m = Integer.parseInt(nm.nextToken());
            int[][] arr = new int[n+1][n+1];

            for (int i = 1; i <= n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] sumArr = new int[n+1][n+1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + arr[i][j];
                }
            }


            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());

                int result = sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1 - 1][y1 - 1];

                writer.write(result + "\n");
            }
            writer.flush();
        }
    }

}
