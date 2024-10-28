package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 경로 찾기
 * 실버 1
 * 문제해석
 * 0~n까지 값이 특정 인덱스에 닿을 수 있는지 알아보는 문제
 *
 * 문제 풀이
 * 플로이드-워셜을 사용해서 닿을 수 있다면 1로 그래프 1로 변경
 */
public class No11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //플로이드 워셜
        for (int i = 0; i < n; i++) {   //중간
            for (int j = 0; j < n; j++) {   //시작
                for (int k = 0; k < n; k++) {   //끝
                    if(graph[j][i] == 1 && graph[i][k] == 1){
                        graph[j][k] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(graph[i][j]).append(' ');
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
