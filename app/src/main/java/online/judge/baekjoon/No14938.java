package online.judge.baekjoon;

import java.util.*;

/**
 * 서강그라운드
 * 골드 4
 */
public class No14938 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int r = scan.nextInt();
        int[] items = new int[n];
        int[][] graph = new int[n][n];

        //지역별 아이템
        for (int i = 0; i < n; i++) {
            items[i] = scan.nextInt();
        }

        //그래프 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i],Integer.MAX_VALUE);
        }

        //길 받기
        for (int i = 0; i < r; i++) {
            int a = scan.nextInt()-1;
            int b = scan.nextInt()-1;
            int c = scan.nextInt();

            graph[a][b] = c;
            graph[b][a] = c;
        }


        //플로이드-워셜
        for (int i = 0; i < n; i++) {//거치는 곳
            for (int j = 0; j < n; j++) {//출발
                for (int k = 0; k < n; k++) {//도착
                    if(j==k || graph[j][i] == Integer.MAX_VALUE
                            || graph[i][k] == Integer.MAX_VALUE) continue;
                    if(graph[j][k] > graph[j][i] + graph[i][k]){
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        //가장 많이 얻을 수 있는 곳 확인
        int max = 0;
        for (int i = 0; i < n; i++) {//내리는 지점
            int cnt = items[i];
            for (int j = 0; j < n; j++) {
                if(i==j) continue;
                if(graph[i][j] <= m) cnt += items[j];
            }
            max = Math.max(cnt, max);
        }

        System.out.println(max);
    }

}
