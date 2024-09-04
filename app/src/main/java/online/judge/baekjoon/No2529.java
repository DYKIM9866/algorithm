package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class No2529 {
    private static long max = Long.MIN_VALUE;
    private static long min = Long.MAX_VALUE;
    private static boolean[] visited = new boolean[10];
    private static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] inequality = new char[n];
        for(int i=0;i<n;i++){
            inequality[i] = st.nextToken().charAt(0);
        }

        values = new int[n + 1];
        //n, 부등호, visited, val
        dfs(n, inequality, 0);

        String maxValue = String.format("%0" + (n+1) + "d", max);
        String minValue = String.format("%0" + (n+1) + "d", min);

        System.out.println(maxValue);
        System.out.print(minValue);

    }

    private static void dfs(int n, char[] inequality, int depth) {
        if(depth == n+1){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                if(inequality[i] == '<'){
                    if(values[i] >= values[i+1]) return;
                }else{ // '>'
                    if(values[i] <= values[i+1]) return;
                }
                sb.append(values[i]);
            }
            sb.append(values[n]);

            max = Long.max(max, Long.parseLong(sb.toString()));
            min = Long.min(min, Long.parseLong(sb.toString()));

            return;
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            values[depth] = i;
            dfs(n, inequality, depth+1);

            visited[i] = false;
        }

    }
}
