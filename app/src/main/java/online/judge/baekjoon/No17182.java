package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 우주 탐사선
 * 골드 3
 * 문제 해석
 * 1. 우주 탐사선 ana호를 타고 모든 행성을 탐사하는데 걸리는 최소 시간을 계산
 * 2. 행성의 개수와 출발하는 행성의 번호가 주어짐
 * 3. 다시 시작 행성으로 돌아올 필요 없고 방문했던 행성도 중복해서 갈 수 있음
 * 4. 모든 행성을 탐험하는데 걸리는 최소시간을 출력하면 됨

 * 문제 풀이
 * 1. 하나의 행성에서 각 해성까지 가는 최소 거리를 구한다.
 * 2. 방법으로는 N이 10으로 작기 때문에 플로이드-와샬 알고리즘을 사용한다.
 * 3. 그 후 dfs를 돌려서 완전탐색을 실시하여 가장 작은 값을 answer에 담아 출력한다.
 */
public class No17182 {
    static int[][] graph;
    static boolean[] visited;
    static int n, k;

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //플로이드 와샬 알고리즘으로 출발지점에서 각 정점으로 가는 최저거리 계산
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i == j) continue;
                    if(graph[i][j] > graph[i][l] + graph[l][j]){
                        graph[i][j] = graph[i][l] + graph[l][j];
                    }
                }
            }
        }

        visited = new boolean[n];
        visited[k] = true;

        dfs(k, 0, 0); //출발, 합, depth

        System.out.println(answer);
    }

    private static void dfs(int k, int sum, int depth) {
        if(depth == n-1){
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(i == k || visited[i]) continue;
            visited[i] = true;
            dfs(i, sum+graph[k][i], depth+1);
            visited[i] = false;
        }

    }
}
