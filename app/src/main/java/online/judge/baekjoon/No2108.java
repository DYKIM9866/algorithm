package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 통계학
 * 실버 3
 * 문제 해석
 * 1. 주어지는 입력의 산술평균, 중앙값, 최빈값, 범위를 출력해라
 * 2. 입력으로
 *  5 (수의 개수)
 *  1 (밑으로 수)
 *  3
 *  8
 *  -2
 *  2
 */
public class No2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        //산술평균을 위한 합
        double sum = 0;
        //범위와 중앙값을 위한 배열
        int[] array = new int[n];
        //최빈값을 위한 배열
        int[] cnt = new int[8001];

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            sum += x;
            array[i] = x;
            cnt[x+4000]++;
        }

        Arrays.sort(array);
        int max = 0;
        int mode = 0;
        boolean flag = true;
        for (int i = array[0] + 4000; i <= array[array.length-1] + 4000; i++) {
            if(max == cnt[i] && flag){
                flag = false;
                mode = i - 4000;
            }else if(max < cnt[i]){
                max = cnt[i];
                mode = i-4000;
                flag = true;
            }
        }


        StringBuilder answer = new StringBuilder();
        answer.append((int)Math.round(sum/n)).append("\n");
        answer.append(array[n / 2]).append("\n");
        answer.append(mode).append("\n");
        answer.append(array[n-1] - array[0]);
        System.out.println(answer);
    }
}
