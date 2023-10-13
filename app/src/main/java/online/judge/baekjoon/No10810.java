package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 공 넣기
 * 완료 230926
 */
public class No10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] strArr = new String[N];
        Arrays.fill(strArr,"0");

        for(int i=0;i<M;i++){
            String[] str = br.readLine().split(" ");

            for(int j=Integer.parseInt(str[0]);j<=Integer.parseInt(str[1]);j++){
                strArr[j-1] = str[2];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strArr.length;i++){
            sb.append(strArr[i]);
            if(i < strArr.length-1){
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
