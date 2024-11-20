package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 저울
 * 골드 2
 *
 * 문제 해석
 * 1. 한쪽에는 무게추 한쪽에는 물건을 두어서 물건의 무게를 맞추려고 한다.
 * 2. 무게추들이 주어질 때 무게추들의 조합으로 측정할 수 없는 최소의 값을 찾아라
 *
 * 문제 풀이
 * 1. dfs는 N이 1000개 까지라 2^1000승으로 시간 초과가 발생한다.
 * 2. 누적합을 이용하면 된다.
 * 3. 무게추들을 가벼운 무게 순으로 정렬한 뒤 누적합을 시작한다.
 * 4. 만약 누적합+1 이 다음 무게추의 무게보다 가볍다면 멈춘다.
 * 5. 왜냐하면 누적합 + 1 무게를 만들 수가 없기 때문이다.
 *     - 이유를 생각해보자 가장 작은 무게 추가 2일 때 시작한다면 누적합이 0이고 0+1은 2보다 작다.
 *     - 이처럼 위의 조건을 만족하지 못하면 무게추의 조합으로 해당 무게를 만들 수가 없다.
 *     - 여러가지 예시를 가지고 시도해 보면 이해 가능하다.
 * 6. 해서 현재까지의 누적합에 1을 더한 값이 답이 된다.
 */
public class No2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] weight = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(weight);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (answer + 1 < weight[i]) {
                break;
            }
            answer += weight[i];
        }

        System.out.println(answer + 1);
    }
}
