package online.judge.baekjoon;

import java.util.*;

/**
 * 센서
 * 골드 5
 */
public class No2212 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        scan.nextLine();
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
        if(k >= set.size()) {
            System.out.println(0);
            return;
        }

        List<Integer> sensor = new ArrayList<>(set);
        sensor.sort(Integer::compareTo);

        int[] diff = new int[sensor.size()-1];
        for (int i = 1; i < sensor.size(); i++) {
            diff[i-1] = sensor.get(i) - sensor.get(i-1);
        }
        Arrays.sort(diff);

        int answer = 0;
        for (int i = 0; i < sensor.size() - k; i++) {
            answer += diff[i];
        }
        System.out.println(answer);
    }
}
