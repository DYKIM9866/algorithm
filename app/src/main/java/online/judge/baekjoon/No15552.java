package online.judge.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 빠른 A+B
 * 완료 230926
 */
public class No15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<count;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(a+b + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
