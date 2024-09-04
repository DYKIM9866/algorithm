package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No14248 {
    static int answer = 0;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] ai = new int[n];
        check = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ai[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(br.readLine());

        dfs(n, ai, s-1);

        System.out.println(answer);
    }

    private static void dfs(int n, int[] ai, int idx) {
        check[idx] = true;
        answer++;

        int val = ai[idx];
        if(idx + val < n && !check[idx + val]){
            dfs(n, ai, idx + val);
        }
        if(idx - val >= 0 && !check[idx - val]){
            dfs(n, ai, idx - val);
        }
    }
}
