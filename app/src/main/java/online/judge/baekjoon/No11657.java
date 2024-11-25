package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 타임머신
 * 골드 4
 *
 * 문제 해석
 * 1. N개의 도시가 있고 도시간 이동하는 버스가 M개 있다.
 * 2. 버스는 출발도시, 도착도시, 시간으로 나타낼 수 있다.
 * 3. 도착하는 시간은 음수 일 수 있다. 시간 역행이 가능 하다는 뜻
 * 4. 1번 도시에서 각 도시로 가는 가장 빠른 시간을 구하면 되는데 무한으로 과거로 갈 수 있는 경우 첫째 줄에 -1 출력
 * 5. 도시로 못가는 경우 -1 출력, 나머지는 시간 출력
 *
 * 문제 풀이
 * 1. 가중치가 음수의 값이 존재한다. 벨만-포드 알고리즘을 사용한다.
 * 2. 벨만포드 알고리즘 내에서 거리 배열을 long으로 해주어야 한다.
 *     - 최악의 경우 500*6000*-10000 의 사이클을 돌아 -30억이 나올 수 있기 때문이다.
 *     - 양의 경우에는 누적될 수 있는 경로에 제한이 있습니다. 사이클에 빠지지 않기 때문이죠
 */
public class No11657 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]> road = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            road.add(new int[]{s, e, w});
        }

        long[] dist = bellmanFord(road, n, m);

        if(dist == null) System.out.println(-1);
        else{
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < n; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append(-1);
                }else{
                    sb.append(dist[i]);
                }
                sb.append("\n");
            }

            System.out.println(sb);
        }
    }

    private static long[] bellmanFord(List<int[]> road, int n, int m) {
        long[] dist = new long[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        // n-1 횟수만큼 모든 노드에서 안정화 시킴
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int[] r = road.get(j);
                //변경이 되었고 갈 곳의 값 보다 현재에서 weight 더한 값이 더 작으면 변경 해줌
                if(dist[r[0]] != Integer.MAX_VALUE && dist[r[0]] + r[2] < dist[r[1]]){
                    dist[r[1]] = dist[r[0]] + r[2];
                }
            }
        }

        // -가중치가 있는지 확인
        for (int j = 0; j < m; j++) {
            int[] r = road.get(j);
            //다시 한번 전체 노드를 안정화 작업을 실행 했을 때 변경되는 값이 발생하면 -가중치 있는 것
            if(dist[r[0]] != Integer.MAX_VALUE && dist[r[0]] + r[2] < dist[r[1]]){
                return null;
            }
        }

        return dist;
    }

}
