package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 좋다
 * 골드4
 *
 * 문제 해석
 * 1. N개의 수가 주어진다.
 * 2. 그중 어떤 수가 다른 두 수의 합과  같다면 그 수는 좋다(Good)
 * 3. 첫째줄에 N이 둘째 줄에는 N개의 숫자가 공백으로 주어진다.
 * 4. 좋은 수의 개수를 찾아라
 * 5. 단 값이 같더라도 수의 위치가 다르면 다른 수이다!!
 *
 * 문제 풀이
 * 1. 투 포인터를 사용해야 한다.
 * 2. 값을 정렬해야 한다. 그렇지 않으면 투포인터를 사용할 때 값을 선택하는 기준을 세울 수가 없다.
 * 3. lt, rt의 첫 값을 정 할 때 rt를 i-1로 하면 안 된다. 값에 음수가 있게 되면 나보다 큰 값에서 찾을 수 있기 때문
 * 4. 값이 정렬되어 있기 때문에 두 개의 합이 현재 값보다 크다면 rt를 낮춰 합을 낮추고 작다면 lt를 늘려 합을 키워준다.
 */
public class No1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            long current = arr[i];
            int lt = 0;
            int rt = n-1;

            //교차 할 때 까지
            while(lt < rt){
                long sum = arr[lt] + arr[rt];
                // 두 합이 같을 경우
                if(sum == current){
                    //나를 포함하는 경우에는 넘어간다.
                    if(lt == i) lt++;
                    else if(rt == i) rt--;
                    else{
                        answer++;
                        break;
                    }
                }else if(sum > current){
                    rt--;
                }else{
                    lt++;
                }
            }
        }

        System.out.println(answer);
    }
}
