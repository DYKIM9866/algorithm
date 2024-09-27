package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 패션왕 신해빈
 * 실버 3
 * 문제 해석
 * 1. 해빈이는 똑같은 조합으로 옷을 입지 않는다.
 * 2. 아무것도 안입는 경우는 존재하지 않고 하나라도 다른 조합으로 입어야 한다.
 * 3. 같은 종류의 옷은 하나만 착용 할 수 있다.
 * 4. 첫째줄에 테스트 케이스의 개수가 입력으로 들어오고
 * 5. 다음 줄 부터 테스트 케이스마다 옷의 개수가 주어지고 이름과 종류가 주어진다.
 */
public class No9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            Map<String, Integer> clothes = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            //가지고 있는 옷이 없으면 0출력 후 continue
            if(n == 0){
                System.out.println(0);
                continue;
            }
            //옷종류를 기반으로 map에 저장
            for (int j = 0; j < n; j++) {
                String[] cloth = br.readLine().split(" ");
                clothes.put(cloth[1],
                        clothes.getOrDefault(cloth[1],0) + 1);
            }

            int answer = 1;
            //종류마다 안입는 경우를 생각해서 1을 더해서 곱해줌
            for(String key : clothes.keySet()){
                answer *= clothes.get(key) + 1;
            }
            //아무것도 안입는 경우는 없으니 -1 해줌
            System.out.println(answer - 1);
        }
    }
}
