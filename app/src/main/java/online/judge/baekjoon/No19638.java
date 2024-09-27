package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 센티와 마법의 뿅망치
 * 실버 1
 * 문제 해석
 * 1. 거인의 나라에서 자신보다 키가 큰 사람을 마법의 망치를 사용해서 작게 만들 것임
 * 2. 마법의 망치는 사용횟수에 제한이 있음
 * 3. 효율적으로 사용하기 위해 가장 큰 사람을 우선적으로 때림
 * 4. 첫번째 줄에 거인의 수 N, 내 키 H, 횟수 제한 T가 공백을 두고 들어옴
 * 5. 다음으로 N만큼의 거인의 키가 들어옴
 *
 * 풀이
 * 1. 우선순위 큐를 사용해서 내림차순으로 바꿔서 사용
 * 2. 반복문을 사용회수가 제한회수 보다 작을 때 까지만 반복
 * 3. 최대값이 1이거나 내 키보다 작으면 break;
 * 4. 마지막에 최대값과 내 키를 비교해서 결과값을 출력
 */
public class No19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nht = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(nht.nextToken());
        int h = Integer.parseInt(nht.nextToken());
        int t = Integer.parseInt(nht.nextToken());

        //우선순위 큐를 내림차순으로 초기화
        PriorityQueue<Integer> heap
                = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            heap.add(Integer.valueOf(br.readLine()));
        }

        //사용횟수
        int cnt = 0;

        while(cnt < t){
            if(heap.peek() == 1 || heap.peek() < h) break;
            heap.offer(heap.poll() / 2);
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        if(heap.peek() < h){
            sb.append("YES").append("\n").append(cnt);
        }else{
            sb.append("NO").append("\n").append(heap.peek());
        }

        System.out.println(sb);
    }
}
