package online.judge.baekjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 회의실 배정
 * 실버 1
 */
public class No1931 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        List<int[]> timeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            timeList.add(new int[]{scan.nextInt(), scan.nextInt()});
        }

        timeList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int[] before = {0, 0};
        for (int[] time : timeList) {
            if(time[0] >= before[1]){
                cnt++;
                before = time;
            }
        }
        System.out.println(cnt);
    }
}
