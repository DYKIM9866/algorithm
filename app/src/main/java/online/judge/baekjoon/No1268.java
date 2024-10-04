package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 임시 반장 정하기
 * 실버 5
 * 문제해석
 * 1. 모든 학생들을 비교해서 다른 학생과 같은 반을  가장 많이 했던 학생을 시킨다.
 * 2. 만약 그런 학생이 여러명인 경우 번호가 가장 작은 학생을 시킨다.
 */
public class No1268 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //학생 수
        int n = Integer.parseInt(br.readLine());
        int[][] chart = new int[n+1][6];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                chart[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSize = 0;
        int answer = 1;
        //학생
        for (int i = 1; i <= n; i++) {
            Set<Integer> sameBan = new HashSet<>();
            for(int j=1;j<=5;j++){
                int ban = chart[i][j];
                for (int k = 1; k <= n; k++) {
                    if(chart[k][j] == ban && k != i) {
                        sameBan.add(k);
                    }
                }
            }
            if(maxSize < sameBan.size()){
                maxSize = sameBan.size();
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
