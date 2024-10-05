package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 최단경로
 * 골드 4
 */
public class No1753 {
    static int v;
    static int e;
    static Map<Integer, List<int[]>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        int[] answerArr = new int[v+1];
        map = new HashMap<>();
        for (int i = 1; i <= v; i++) {
            map.put(i, new ArrayList<>());
            answerArr[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            map.get(s).add(new int[]{a,val});
        }

        bfs(start, answerArr);
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= v; i++) {
            if(answerArr[i] == Integer.MAX_VALUE){
                answer.append("INF").append("\n");
            }else{
                answer.append(answerArr[i]).append("\n");
            }
        }

        System.out.println(answer);
    }

    private static void bfs(int start, int[] answerArr) {
        PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));

        que.offer(new int[]{start, 0});
        answerArr[start] = 0;

        while(!que.isEmpty()){
            int[] current = que.poll();

            for(int[] node : map.get(current[0])){
                int value = node[0];
                int weight = node[1];

                if(answerArr[current[0]] + weight < answerArr[value]){
                    answerArr[value] = answerArr[current[0]] + weight;
                    que.add(new int[]{value, answerArr[value]});
                }
            }
        }
    }
}
