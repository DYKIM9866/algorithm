package online.judge.baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 타임머신
 * 골드 4
 */
public class No11657 {
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //도시의 개수
        n = scan.nextInt();
        //버스의 개수
        m = scan.nextInt();

        //그래프 초기화
        List<int[]> graph = new ArrayList<>();

        //그래프 담기
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt() - 1;
            int b = scan.nextInt() - 1;
            int weight = scan.nextInt();

            //출발, 도착, 시간
            graph.add(new int[]{a, b, weight});
        }

        //벨만포드 알고리즘
        long[] dis = bellmanFord(graph);

        //답 담기
        StringBuilder answer = new StringBuilder();
        if(dis == null) answer.append(-1);
        else{
            for (int i = 1; i < n; i++) {
                if(dis[i] == Long.MAX_VALUE){
                    answer.append(-1).append("\n");
                }else{
                    answer.append(dis[i]).append("\n");
                }
            }
        }

        System.out.println(answer);
    }

    private static long[] bellmanFord(List<int[]> graph) {
        //거리 배열
        long[] dis = new long[n];
        //초기값 설정
        Arrays.fill(dis, Long.MAX_VALUE);
        dis[0] = 0;

        //안정화
        for (int i = 0; i < n - 1; i++) {
            for(int[] route : graph){
                if(dis[route[0]] != Long.MAX_VALUE
                    && dis[route[0]] + route[2] < dis[route[1]]){
                    dis[route[1]] = dis[route[0]] + route[2];
                }
            }
        }

        //무한히 작아지는 부분 있는지 확인
        for(int[] route : graph){
            if(dis[route[0]] != Long.MAX_VALUE
                    && dis[route[0]] + route[2] < dis[route[1]]){
                return null;
            }
        }

        return dis;
    }

}
