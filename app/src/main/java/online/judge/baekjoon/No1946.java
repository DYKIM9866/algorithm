package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 신입 사원
 * 실버 1
 * 문제 해석
 * 1. 서류 순위와 면접 순위가 주어진다.
 * 2. 채용 기준은 지원자 중 서류 순위와 면접순위가 다른 인원에게 하나라도 앞선다면 뽑는다.
 * 3. 테스트 케이스만틈 반복하여 몇명이 뽑힐 수 있는지 출력해라
 *
 * 풀이
 * 1. 한가지 기준으로 정렬한다.(서류로 가정)
 * 2. 서류 1위부터 아래로 내려가면서 면접 순위를 비교한다.
 * 3. 면접 순위가 기준보다 낮다면(2 > 5) 탈락 인원을 센다.
 * 4. 높다면 (2 < 1) 비교 기준을 바꾼다.
 */
public class No1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                list.add(new int[]{Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())});
            }
            Collections.sort(list, (i,j) -> i[0] - j[0]);

            int cnt = 0;
            int comparison  = list.get(0)[1];
            for (int i = 1; i < n; i++) {
                if(comparison < list.get(i)[1]){
                    cnt++;
                    continue;
                }
                comparison = list.get(i)[1];
            }

            System.out.println(list.size() - cnt);
        }
    }
}
