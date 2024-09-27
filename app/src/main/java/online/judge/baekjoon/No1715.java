package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 카드 정렬하기
 * 골드 4
 * 문제 해석
 * 1. 두 카드 뭉치를 합치려면 두개의 합 만큼의 비교가 필요하다.
 * 2. 가장 적게 비교하도록 합치고 싶다.
 * 3. 예를들어 10 20 40 이 존재 할 때  10 + 20을 만들고 합쳐진 30 + 40을 하면 총 100번
 * 4. 20 40을 먼저 합치고 10 60을 합치면 130이 된다.
 * 5. 가장 적게 합치는 경우를 찾아라
 *
 * 풀이
 * 1. 최소 힙을 선언해서 값들을 담는다.
 * 2. 두개의 뭉치를 poll해서 합친 후 다시 힙에 담는다.
 * 3. 힙에 한개의 카드뭉치만 남을 때까지 반복한다.
 */
public class No1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            heap.add(Integer.valueOf(br.readLine()));
        }

        int answer = 0;
        while(heap.size() != 1){
            int sum = heap.poll() + heap.poll();
            answer += sum;
            heap.add(sum);
        }
        System.out.println(answer);
    }
}
