package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 키 순서
 * 골드 4
 * 플로이드 워샬
 */
public class No2458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        //학생 수와 비교 횟수
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //학생 간 관계를 나타 낼 배열
        int[][] tallCom = new int[n][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            tallCom[a][b] = 1;
            tallCom[b][a] = 2;
        }

        //비교해서 작은거는 1로 큰거는 2로
        for (int i = 0; i < n; i++) {// 중간 비교
            for (int j = 0; j < n; j++) {//앞
                for (int k = 0; k < n; k++) {//뒤
                    if(tallCom[j][i] == 1 && tallCom[i][k] == 1){
                        tallCom[j][k] = 1;
                        tallCom[k][j] = 2;
                    }
                }
            }
        }

        //관계가 명확하지 않으면(본인을 제외한 0이 또 있다면 안됨) 넘어감
        int answer = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                if(tallCom[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }
        System.out.println(answer);
    }

}
