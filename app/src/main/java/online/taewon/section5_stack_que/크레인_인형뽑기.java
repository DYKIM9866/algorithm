package online.taewon.section5_stack_que;

import java.util.Scanner;
import java.util.Stack;

public class 크레인_인형뽑기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = scan.nextInt();
            }
        }

        int m = scan.nextInt();
        int[] moves = new int[m];
        for(int i=0;i<m;i++){
            moves[i] = scan.nextInt() - 1;
        }

        System.out.println(mySol(n,board,m,moves));
    }

    private static int mySol(int n, int[][] board, int m, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();

        for(int x : moves){
            for(int i=0;i<n;i++){
                if(board[i][x] == 0) continue;
                else {
                    stack.push(board[i][x]);
                    board[i][x] = 0;
                    break;
                }
            }
            if(stack.size() > 1){
                int one = stack.pop();
                if(one == stack.peek()){
                    stack.pop();
                    result += 2;
                }else{
                    stack.push(one);
                }
            }
        }


        return result;
    }
}
