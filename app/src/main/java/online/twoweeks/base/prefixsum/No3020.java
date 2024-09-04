package online.twoweeks.base.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준
 * 개똥벌레
 *
 */
public class No3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nh = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nh.nextToken());
        int h = Integer.parseInt(nh.nextToken());

        int[] hArr = new int[h];

        for (int i = 0; i < n; i++) {
            int obstacle = Integer.parseInt(br.readLine());
            if(i % 2 == 0){
                hArr[0] += 1;
                hArr[obstacle] += -1;
            }else{
                hArr[h-obstacle] += 1;
            }
        }

        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 1; i < h; i++) {
            hArr[i] += hArr[i-1];
            min = Math.min(min,hArr[i]);
        }
        for (int i = 0; i < h; i++) {
            if(hArr[i] == min) cnt++;
        }

        System.out.println(min +" " + cnt);

    }
}
