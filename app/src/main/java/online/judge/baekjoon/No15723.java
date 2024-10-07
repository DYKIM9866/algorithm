package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * n단 논법
 * 실버 1
 */
public class No15723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //배열
        boolean[][] record = new boolean[26][26];
        int n = Integer.parseInt(br.readLine());
        while (n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';

            record[a][b] = true;
        }

        for(int i=0;i<26;i++){
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if(record[j][i] && record[i][k]){
                        record[j][k] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int b = st.nextToken().charAt(0) - 'a';

            if(record[a][b]){
                sb.append("T");
            }else{
                sb.append("F");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
