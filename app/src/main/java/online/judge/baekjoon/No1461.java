package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 도서관
 * 골드 4
 *
 * 문제 해석
 * 1. 세준이와 가져다 놓아야 할 책 N개가 위치 0에 있다.
 * 2. 세준이는 M개씩 가지고 다닐 수 있다.
 * 3. 둘째 줄에 책의 본래 위치들이 주어진다.
 * 4. 세준이는 가장 적게 움직여서 임무를 완수하려고 한다.
 * 5. 가장 적게 돌아다닌 경우의 걸음 수를 출력하라
 *
 * 문제 풀이
 * 1. 가장 먼 곳은 마지막에 가서 돌아올 필요가 없으므로 한번만 더해준다.
 * 2. 0을 기준으로 어떤 방향으로 갈 때 M개로 떨어지지 않는다면 작은 나머지 부터 가줘야 가장 적게 갈 수 있다
 *     - ex) -39 -37 -29 -28 -6 0 2 11  여기서 두개씩 가져갈 수 있다면 (-6),(-29,-28),(-37,-39) 이렇게 가야 가장 적다.]
 * 3. 양 방향으로 절대값 기준으로 풀이 할 것이기 때문에 두개의 PriorityQueue에 절대값 기준으로 내림차순한다.
 * 4. 마지막 답에서 가장 큰 경우를 한 번 빼준다.
 *
 */
public class No1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //위치를 담을 +,- 따로 내림차순 저장
        PriorityQueue<Integer> positive = new PriorityQueue<>((t1, t2) -> t2 - t1);
        PriorityQueue<Integer> negative = new PriorityQueue<>((t1, t2) -> t2 - t1);


        //max값 저장
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());

            max = Math.max(max, Math.abs(temp));

            if(temp > 0) positive.add(temp);
            else negative.add(-1 * temp);
        }

        int answer = 0;
        //오른쪽 비워주기
        while(!positive.isEmpty()){
            int val = positive.peek();
            for (int i = 0; i < m; i++) {
                positive.poll();
                if(positive.isEmpty()) break;
            }

            answer += val * 2;
        }

        //왼쪽 비워주기
        while(!negative.isEmpty()){
            int val = negative.peek();
            for (int i = 0; i < m; i++) {
                negative.poll();
                if(negative.isEmpty()) break;
            }

            answer += val * 2;
        }

        //최대값 한번 빼줌
        answer -= max;
        System.out.println(answer);
    }
}
