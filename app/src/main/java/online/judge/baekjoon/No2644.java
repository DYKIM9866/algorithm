package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2644 {
    static int answer = 0, cnt = 0;
    static int n,b;
    static boolean[][] relation;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        relation = new boolean[n+1][n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            StringTokenizer pc = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(pc.nextToken());
            int y = Integer.parseInt(pc.nextToken());
            relation[x][y] = true;
            relation[y][x] = true;
        }

        dfs(a);
        if(!flag) answer = -1;
        System.out.println(answer);

    }

    private static void dfs(int a) {
        if(a == b) {
            answer = cnt;
            flag = true;
        }
        if(flag) return;

        for(int i=1;i<=n;i++){
            if(flag) break;
            if(!relation[a][i]) continue;
            relation[i][a] = false;
            cnt++;
            dfs(i);
            cnt--;
            relation[i][a] = true;
        }
    }
}
