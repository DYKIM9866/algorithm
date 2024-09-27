package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 크리스마스 선물
 * 실버 3
 * 문제 해석
 * 1. 산타가 돌아다니면서 아이들에 선물을 나누어준다.
 * 2. 거점에 도착했을 때 선물을 채운다.
 * 3. 아이들을 만날 때마다 가지고 있는 것중 가장 가치가 높은 선물을 주고 가치를 출력한다
 * 4. 가지고 있는 선물이 없다면 -1을 출력한다.
 *
 * 풀이
 * 1. 우선순위 큐를 이용하여 maxHeap을 선언해준다.
 * 2. 만약 입력받은 길이가 1보다 클 경우 거점이기 때문에 maxHeap에 추가해준다.
 * 3. 아이들을 만나면 maxHeap을 poll 해준다.
 * 4. 아이들을 만났을 때 가진게 없다면 -1을 출력한다.
 */
public class No14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap
                = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            if(str.length != 1){
                int ea = Integer.parseInt(str[0]);
                for (int j = 1; j <= ea; j++) {
                    maxHeap.offer(Integer.valueOf(str[j]));
                }
            }else{
                if(maxHeap.isEmpty()) System.out.println(-1);
                else System.out.println(maxHeap.poll());
            }
        }
    }
}
