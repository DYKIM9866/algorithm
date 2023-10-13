package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 약수 구하기
 * 완료 231005
 */
public class No2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++){
            if(N%i == 0){
                sb.append(i + " ");
                count += 1;
            }
        }
        String[] strArr = sb.toString().split(" ");
        if(strArr.length < K){
            System.out.println(0);
        }else{
            System.out.println(strArr[K-1]);
        }


    }
}
