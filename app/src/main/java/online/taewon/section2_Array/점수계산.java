package online.taewon.section2_Array;

import java.util.Scanner;

public class 점수계산 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] answerSheet = new int[n+1];
        for(int i=1;i<=n;i++){
            answerSheet[i] = scan.nextInt();
        }

        System.out.println(mySol(n, answerSheet));
    }

    private static int mySol(int n, int[] answerSheet) {
        int result = 0;
        int[] score = new int[n+1];

        for(int i=1;i<=n;i++){
            if(answerSheet[i] == 1){
                score[i] = score[i-1] + 1;
                result += score[i];
            }
        }
        return result;
    }
}
