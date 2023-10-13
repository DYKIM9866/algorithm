package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 색종이
 * 완료 230927
 */
public class No2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] paper = new int[100][100];

        while(n-->0){
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i=x;i<=x+9;i++){
                for(int j=y;j<=y+9;j++){
                    paper[i][j] = 1;
                }
            }
        }

        int sum = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(paper[i][j] == 1){
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
