package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 케빈 베이컨의 6단계 법칙
 * 실버 1
 *
 * 문제 해석
 * 1. 6 관계만 거치면 모든 사람과 연결된다는 6단계 법칙을 문제로 만든 것이다.
 * 2. 케빈베이컨 게임은 모인사람들과의 단계의 합이 가장 적은 사람이 이기는 게임이다.
 * 3. 가장 작은 단계의 합을 가진 사람을 구하라
 *
 * 문제 풀이
 * 1. N이 100이하이므로 플로이드-워셜 사용
 * 2. 거치는 관계가 있을 때 조건문 추가
 *  - 닿아있지 않다면 거치는 관계를 넣어줌
 *  - 닿아있다면 원래 값과 거치는 값 중 작은 값을 넣어줌
 */
public class No1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        //플로이드-워셜
        for (int i = 0; i < n; i++) {// 거쳐가기
            for (int j = 0; j < n; j++) {// 출발
                for (int k = 0; k < n; k++) {// 도착
                    if(graph[j][i]!=0 && graph[i][k] !=0){
                        if(graph[j][k] == 0){
                            graph[j][k] = graph[j][i] + graph[i][k];
                        }else{
                            graph[j][k] = Math.min(graph[j][k],
                                    graph[j][i] + graph[i][k]);
                        }
                    }
                }
            }
        }

        int minValue = Integer.MAX_VALUE;
        int answer = -1;
        for (int i = 0; i < n; i++) {
            int sum =0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                sum += graph[i][j];
            }
            if(sum < minValue){
                answer = i+1;
                minValue = sum;
            }
        }

        System.out.println(answer);
    }
}
