package online.twoweeks.base.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No15649 {
        static int n;
        static int m;
        static int[] check;
        static int[] sol;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new int[n+1];
        sol = new int[m];

        solution(0);
    }

    private static void solution(int depth) {
        if(depth == m){
            for(int x : sol) System.out.print(x + " ");
            System.out.println();
            return;
        }
        for(int i=1;i<=n;i++){
            if(check[i] == 1) continue;
            check[i] = 1;
            sol[depth] = i;
            solution(depth + 1);
            check[i] = 0;
        }
    }

}
