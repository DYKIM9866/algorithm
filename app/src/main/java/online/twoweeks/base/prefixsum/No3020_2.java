package online.twoweeks.base.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3020_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nh = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nh.nextToken());
        int h = Integer.parseInt(nh.nextToken());

        int[] bottom = new int[h + 1];
        int[] top = new int[h + 1];

        for (int i = 0; i < n; i++) {
            int obstacle = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                bottom[obstacle]++;
            } else {
                top[obstacle]++;
            }
        }

        int[] prefixBottom = new int[h + 1];
        int[] prefixTop = new int[h + 1];

        // Calculate prefix sums for bottom
        for (int i = 1; i <= h; i++) {
            prefixBottom[i] = prefixBottom[i - 1] + bottom[i];
        }

        // Calculate prefix sums for top
        for (int i = 1; i <= h; i++) {
            prefixTop[i] = prefixTop[i - 1] + top[i];
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for (int i = 1; i <= h; i++) {
            int totalObstacles = prefixBottom[h] - prefixBottom[i - 1] + prefixTop[h] - prefixTop[h - i];
            if (totalObstacles < min) {
                min = totalObstacles;
                cnt = 1;
            } else if (totalObstacles == min) {
                cnt++;
            }
        }

        System.out.println(min + " " + cnt);
    }
}

