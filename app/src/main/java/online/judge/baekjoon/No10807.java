package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 개수 세기
 * 완료 230926
 */
public class No10807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int find = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i=0;i<count;i++){
            if(find == Integer.parseInt(st.nextToken())){
                result++;
            }
        }
        System.out.println(result);
    }
}
