package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 2
 * 신나는 함수 실행
 * 완료
 */
public class No9184 {
    private static int[][][] check = new int[101][101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String[] strArr= br.readLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            int c = Integer.parseInt(strArr[2]);
            if(a == -1 && b == -1 && c == -1) return;

            int val = w(a,b,c);
            System.out.printf("w(%d, %d, %d) = %d",a,b,c,val);
            System.out.println();
        }
    }

    private static int w(int a, int b, int c) {
        if(check[a+50][b+50][c+50] != 0) return check[a+50][b+50][c+50];
        if(a <= 0 || b <= 0 || c <= 0){
            check[a+50][b+50][c+50] = 1;
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            check[a+50][b+50][c+50] = w(20,20,20);
            return check[a+50][b+50][c+50];
        }
        if(a < b && b < c){
            check[a+50][b+50][c+50] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
            return check[a+50][b+50][c+50];
        }

        check[a+50][b+50][c+50] = w(a-1, b, c) + w(a-1, b-1, c)
                + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        return check[a+50][b+50][c+50];
    }
}
