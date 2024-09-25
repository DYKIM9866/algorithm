package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 골드 5
 * 정보 상인 호석
 * 조건에 맞춰 구현하면 되는 문제
 * Map의 키를 고릴라의 이름으로 주고, 값을 우선순위 큐로 둔다.
 * 결과 값은 정수범위를 벗어나기 때문에 long으로 둔다.
 * 완료
 */
public class No22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> gorilla = new HashMap<>();

        long answer = 0;

        for(int i=0;i<q;i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("2")) {//호석
                PriorityQueue<Integer> info =
                        gorilla.get(command[1]);
                if(info == null || info.isEmpty()) continue;
                for(int j=0;j<Integer.parseInt(command[2]);j++){
                    if(info.isEmpty()) break;
                    answer += info.poll();
                }
            }else{//고릴라
                PriorityQueue<Integer> info =
                        gorilla.getOrDefault(command[1],new PriorityQueue<>(Comparator.reverseOrder()));
                for(int j=3;j<Integer.parseInt(command[2])+3;j++){
                    info.add(Integer.parseInt(command[j]));
                }
                gorilla.put(command[1],info);
            }
        }

        System.out.println(answer);
    }
}
