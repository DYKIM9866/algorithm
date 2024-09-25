package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 골드 5
 * 아즈버의 이빨 자국
 * 완료
 */
public class No30105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] teethMark = new int[n];
        Map<Integer, Boolean> teeth = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            teethMark[i] = tmp;
            teeth.put(tmp, false);
        }



        for (int i = 1; i < n; i++) {
            int k = teethMark[i] - teethMark[0];
            Map<Integer, Boolean> check = new HashMap<>(teeth);
            int cnt = 0;
            for(int j=0;j<n;j++){
                boolean tmp1 = check.get(teethMark[j]);
                Boolean tmp2 = check.get(teethMark[j]+k);
                if(tmp2 != null){
                    if(!tmp1){
                        cnt++;
                        check.put(teethMark[j], true);
                    }
                    if(!tmp2){
                        cnt++;
                        check.put(teethMark[j]+k, true);
                    }
                }
            }
            if(cnt == n){
                answer.add(k);
            }
        }
        answer.sort(Integer::compareTo);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for(int x : answer){
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
