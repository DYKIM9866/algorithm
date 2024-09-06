package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 골드 5
 * 하노이 탑 이동 순서
 * dp로 풀이하려고 했으나 이동 순서가 있어서 재귀로 풀이
 * 완료
 */
public class No11729 {
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int[] arr : list){
            sb.append(arr[0]).append(" ").append(arr[1])
                    .append("\n");
        }
        System.out.println(sb);
    }

    private static void hanoi(int n, int start, int mid, int end) {
        if(n == 1){
            list.add(new int[]{start, end});
            return;
        }
        hanoi(n-1, start, end, mid);
        list.add(new int[]{start,end});
        hanoi(n-1, mid, start, end);
    }
}
