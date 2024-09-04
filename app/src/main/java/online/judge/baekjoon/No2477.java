package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 완료
 */
public class No2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[][] map = new int[12][2];
        int area = 0;

        for(int i=0;i<6;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            map[i] = new int[]{direction,distance};
        }
        for(int i=6;i<12;i++){
            map[i] = map[i-6];
        }

        for(int i=2;i<11;i++){
            if(map[i][0] == map[i-2][0] && map[i+1][0] == map[i-1][0]){
                area = map[i+2][1] * map[i+3][1];
                area -= map[i][1] * map[i-1][1];
                break;
            }
        }

        System.out.println(area * k);
    }
}
