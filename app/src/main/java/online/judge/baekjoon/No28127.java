package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 숫자탑과 쿼리
 * 계차수열 이용한 문제
 * 완료
 *
 */
public class No28127 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());
        for(int i=0;i<q;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int frontVal = 1;
            int n = 1;

            while(true){
                //계차수열
                int tmp = a + (n-1) * d;
                //넘어가는 값이 x보다 크면 안되기 때문에 조건을 더했을 때 크면으로
                if(frontVal + tmp > x){
                    //현재 층수와 몇번째에 있는지 출력
                    System.out.println(n + " " + (x - frontVal + 1));
                    break;
                }
                //값이 넘어가지 않는다면 값 더해줌
                frontVal += tmp;
                n++;
            }

        }
    }
}
