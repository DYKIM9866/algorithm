package online.judge.baekjoon;

import java.util.Scanner;

/**
 * N-Queen
 * 골드 4
 */
public class No9663 {
    static int n;
    static int[] board;
    static int result = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        board = new int[n];

        solution(0);
        System.out.println(result);
    }

    private static void solution(int row) {
        //row 다 돌았으면 경우의 수 추가
        if(row == n){
            result++;
            return;
        }
        //행에 어디 열에 둘지 정하기
        for (int col = 0; col < n; col++) {
            //둬도 되냐
            if(isSafe(row, col)){
                board[row] = col;
                solution(row+1);
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        //이전 row 돌면서 해당 col에 걸리지 않는지
        for (int i = 0; i < row; i++) {
            //같은 열에 있다면 안되고, 대각선에 있다면 안됨 대각선은 행의 차와 열의 차가 같다면 대각선이라는 뜻
            if(board[i] == col || row - i == Math.abs(col - board[i])){
                return false;
            }
        }
        return true;
    }
}
