package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 스위치 켜고 끄기
 * 실버 4
 * 문제 해석
 * 1. 1부터 연속적으로 번호가 붙어있는 스위치가 주어진다.
 * 2. 스위치는 꺼져있거나 켜져있다.
 * 3. 학생을 뽑아서 켜거나 끄게 할 텐데 그 방법은, 각 학생들에게 1~스위치번호 중 하나를 준다.
 * 4. 남학생은 자신이 가진 번호의 배수의 스위치를 눌러 바꾼다.
 * 5. 여학생은 자신이 가진 번호를 중심으로 대칭이 되는 스위치들을 바꾼다.
 * 6.  입력은
 * `8   스위치 수 (100이하의 양의 정수)
 *  0 1 0 1 0 0 0 1 스위치 상태 (0 꺼진 상태 1 켜진 상태)
 *  2   학생 수 (100 이하의 양의 정수)
 *  1 3 학생, 번호 (남학생 1 여학생 2, 스위치 번호)
 *  2 3`
 *
 *  풀이
 *  1. 그대로 구현하면 된다.
 *  2. 남학생 같은 경우는 for문을 사용해 num씩 더해가면서 스위치를 변경해준다.
 *  3. 여학생 같은 경우는 lt rt를 정해서 비교하다가 다르다면 비교한 곳 까지 바꿔주면 된다.
 *
 */
public class No1244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sw = Integer.parseInt(br.readLine());
        int[] swState = new int[sw+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= sw; i++) {
            swState[i] = Integer.parseInt(st.nextToken());
        }

        int student = Integer.parseInt(br.readLine());
        while(student --> 0){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(gender == 1){
                for (int i = num; i <= sw; i+=num) {
                    if(swState[i]==0) swState[i] = 1;
                    else swState[i] = 0;
                }
            }else{
                int lt = num-1;
                int rt = num+1;
                while(lt >= 1 && rt<=sw){
                    if(swState[lt] == swState[rt]){
                        lt--;
                        rt++;
                    }else break;
                }
                for (int i = lt+1; i <= rt-1; i++) {
                    if(swState[i]==0) swState[i] = 1;
                    else swState[i] = 0;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= sw; i++) {
            answer.append(swState[i]).append(' ');
            if(i % 20 == 0) answer.append("\n");
        }

        System.out.println(answer);
    }
}
