package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판 다시 칠하기 실버4
 * 미완
 */
public class No1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] intArr = new int[n][m];
        for(int i=0;i<n;i++){
            String[] line = reader.readLine().split("");
            for(int j=0;j<m;j++){
                intArr[i][j] = Integer.parseInt(line[j]);
            }
        }

        //자르기
        for(int i=0;i<n-8+1;i++){
            for(int j=0;j<m-8+1;j++){

            }
        }

    }
}
