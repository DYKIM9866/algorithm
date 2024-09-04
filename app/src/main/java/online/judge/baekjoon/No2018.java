package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 5
 * 수들의 합 5
 * 슬라이딩 윈도우를 사용해서 풀이
 * 완료
 */
public class No2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //lt와 rt를 설정하여 lt와 rt사이의 값을 누적하는 sum을 초기화
        int lt = 1;
        int rt = 1;
        int sum = 1;
        int answer = 0;
        //lt가 n과 같을 때 까지만

        while(lt <= n){
            /**
             * sum이 n과 같을 경우는 결과값을 1올려주고 rt를 더 함
             * 클 경우 lt를 높여주면서 간격을 좁힘
             * 작을 경우 rt를 높여주면서 간격을 벌림
             */
            if(sum == n){
                answer++;
                sum+=++rt;
            }else if(sum > n){
                sum -= lt++;
            }else if(sum < n){
                sum += ++rt;
            }
        }

        System.out.println(answer);
    }
}
