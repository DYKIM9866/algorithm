package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 좌표 압축
 * 실버 2
 * 문제 해석
 * 1. 입력 N 개수에 맞춰 정수가 들어온다.
 * 2. 좌표 압축은 전체 배열에서 나보다 작은 수의 개수를 의미한다.
 * 3. 나보다 낮은 개수가 몇개인지 각 위치에 출력하면 된다.
 *
 * 풀이
 * 1. List에 담을 때 정수와 좌표의 인덱스를 함께 담는다.
 * 2. 값을 기준으로 정렬한다.
 * 3. 0부터 뒤로 가면서 만약 값이 이전 정수와 같지 않다면 넣어줄 개수에 ++해준다.
 * 4. 정답배열에 해당 정수를 가진 인덱스에 값을 넣어준다.
 * 5. before를 초기화 해준다.
 */
public class No18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(new int[]{Integer.parseInt(st.nextToken()), i});
        }

        list.sort((i,j) -> i[0] - j[0]);

        int[] answerArr = new int[n];
        int insertCnt = -1;
        int before = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(before != list.get(i)[0]){
                insertCnt++;
            }
            answerArr[list.get(i)[1]] = insertCnt;

            before = list.get(i)[0];
        }

        StringBuilder answer = new StringBuilder();
        for(int x : answerArr){
            answer.append(x).append(' ');
        }

        System.out.println(answer);
    }
}
