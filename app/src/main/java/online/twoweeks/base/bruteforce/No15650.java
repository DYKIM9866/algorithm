package online.twoweeks.base.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15650 {
    static int n;
    static int m;
    static boolean[] check;
    static int[] sol;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new boolean[n+1];
        sol = new int[m];

        solution(0,1);
    }

    private static void solution(int depth, int val) {
        if(depth == m){
            for(int x : sol) System.out.print(x + " ");
            System.out.println();
            return;
        }
        for(int i=val;i<=n;i++){
            if(check[i]) continue;
            check[i] = true;
            sol[depth] = i;
            solution(depth+1, i+1);
            check[i] = false;
        }
    }
}
