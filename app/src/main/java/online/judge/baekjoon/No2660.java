package online.judge.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 회장뽑기
 * 골드 5
 */
public class No2660 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] friends = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(friends[i],Integer.MAX_VALUE);
        }

        while(true){
            int a = scan.nextInt()-1;
            int b = scan.nextInt()-1 ;
            if(a == -2) break;

            friends[a][b] = 1;
            friends[b][a] = 1;
        }

        for (int i = 0; i < n; i++) {//거침
            for (int j = 0; j < n; j++) {//출발
                for (int k = 0; k < n; k++) {//도착
                    if(friends[j][i] != Integer.MAX_VALUE
                            && friends[i][k] != Integer.MAX_VALUE){
                        friends[j][k] = Math.min(friends[j][k],
                                friends[j][i] + friends[i][k]);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int minScore = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                max = Math.max(max, friends[i][j]);
            }
            if(minScore > max){
                minScore = max;
                cnt = 1;
                sb.setLength(0);
                sb.append(i+1).append(' ');
            }else if(minScore == max){
                cnt++;
                sb.append(i+1).append(' ');
            }
        }

        StringBuilder answer = new StringBuilder();

        answer.append(minScore).append(' ').append(cnt).append("\n")
                .append(sb);

        System.out.println(answer);
    }

}
