package online.taewon.section2_Array;

import java.util.Arrays;
import java.util.Scanner;

public class 등수구하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] score = new int[n];
        for(int i=0;i<n;i++){
            score[i] = scan.nextInt();
        }

        System.out.println(mySol(n, score));
    }

    private static String mySol(int n, int[] score) {
        String result = "";
        int[] grade = new int[n];
        Arrays.fill(grade,1);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(score[i] > score[j]){
                    grade[j]++;
                }
            }
        }

        for(int x : grade){
            System.out.print(x + " ");
        }


        return result;
    }

}
