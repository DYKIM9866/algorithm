package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 30
 * 실버 4
 * 문제 해석
 * 1. 길거리에서 만난 양수 N을 자릿수 상관없이 숫자를 섞어서 30의 배수가 되는지 확인
 * 2. 된다면 되는 값을 안된다면 -1을 출력
 *
 * 풀이
 * 1. 각 자리의 값의 합이 3의 배수가 아니면 탈락
 * 2. 정렬 값의 앞자리가 0이 아니면 탈락
 * 3. 조건에 맞는다면 가장 큰 값으로 정렬하면 30의 배수가 된다.
 */
public class No10610 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] n = br.readLine().toCharArray();

        int sum = 0;
        for (char chr : n) {
            sum += chr - '0';
        }
        if(sum % 3 != 0) System.out.println(-1);
        else{
            Arrays.sort(n);
            if(n[0] != '0') System.out.println(-1);
            else{
                StringBuilder sb = new StringBuilder();
                for (int i = n.length-1; i >=0; i--) {
                    sb.append(n[i]);
                }
                System.out.println(sb);
            }
        }
    }

}
