package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//단지 구현해야 하는 문제
//완료
public class No17207 {
    public static void main(String[] args) throws IOException {

        //번호 순서대로 이름 초기화
        String[] name = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //난이도, 처리시간 배열 초기화
        int[][] a = new int[5][5];
        int[][] b = new int[5][5];

        //배열 입력 받기
        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<5;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                b[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        //계산 값을 넣을 배열을 사람 수에 맞춰 초기화
        int[] work = new int[5];
        //계산식에 맞춰 계산 후 삽입
        for(int i=0;i<5;i++){ //사람
            for(int j=0;j<5;j++){   //난이도
                for(int k=0;k<5;k++){   //처리시간
                    work[i] += a[i][j] * b[j][k];
                }
            }
        }


        //출력 할 때 필요한 인덱스, min값 정수 최대값으로 초기화
        int idx = -1;
        int min = Integer.MAX_VALUE;

        //최소값일 경우 값 변경
        //같은 최소 값일 경우에는 뒤에 인덱스에 있는 경우를 우선으로 변경
        for(int i=0;i<5;i++){
            if(work[i] <= min){
                idx = i;
                min = work[i];
            }
        }

        System.out.println(name[idx]);
    }
}
