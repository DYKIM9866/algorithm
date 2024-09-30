package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 보석 도둑
 * 골드 2
 */
public class No1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer nk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(nk.nextToken());
        int k = Integer.parseInt(nk.nextToken());

        List<int[]> jewel = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer mv = new StringTokenizer(br.readLine());
            jewel.add(new int[]{Integer.parseInt(mv.nextToken())
                    , Integer.parseInt(mv.nextToken())});
        }

        int[] bag = new int[k];
        for (int i = 0; i < k; i++) {
            bag[i] = (Integer.parseInt(br.readLine()));
        }

        jewel.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o2[1] - o1[1];
                };
                return o1[0] - o2[0];
            }
        });

        Arrays.sort(bag);

        long maxValue = 0;

        PriorityQueue<Integer> jewelValue
                = new PriorityQueue<>(Comparator.reverseOrder());

        int j = 0;
        for (int i = 0; i < k; i++) {
            int weight = bag[i];
            while(j<n && jewel.get(j)[0] <= weight){
                jewelValue.offer(jewel.get(j++)[1]);
            }

            if(!jewelValue.isEmpty()){
                maxValue += jewelValue.poll();
            }
        }


        System.out.println(maxValue);
    }
}
