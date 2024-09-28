package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 30번
 * 실버 4
 * 문제 해석
 * 1. 트리구조로 1023까지 작성되어있다.
 * 2. 두개의 수가 주어졌을 값이 최대인 공통 조상을 찾으면 된다.
 * 3. 테스트 케이스가 주어지고 테스트 케이스 만큼 두 수가 주어진다.
 * 4. 케이스마다 값을 출력하면 된다.
 *
 * 풀이
 * 1. 내 조상은 나를 2로 나눈값이다.
 * 2. 더 큰 값을 2로 나누어서 비교한다.
 * 3. 값이 같아질 경우를 찾는다.
 */
public class No13116 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] ab = br.readLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            while(a != b){
                if(a > b){
                    a = a/2;
                }else{
                    b = b/2;
                }
            }

            sb.append(a*10).append("\n");
        }
        System.out.println(sb);

    }
}
