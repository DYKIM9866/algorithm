package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 파일 합치기 3
 * 골드 4
 */
public class No13975 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int k = Integer.parseInt(br.readLine());
            PriorityQueue<Long> heap = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                heap.offer(Long.valueOf(st.nextToken()));
            }
            long size = 0;
            while(heap.size() != 1){
                long x = heap.poll();
                long y = heap.poll();
                heap.offer(x + y);
                size += x+y;
            }

            System.out.println(size);
        }
    }
}
