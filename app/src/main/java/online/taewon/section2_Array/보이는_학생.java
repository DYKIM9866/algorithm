package online.taewon.section2_Array;

import java.util.Scanner;

public class 보이는_학생 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] tallList = new int[n];
        for(int i=0;i<n;i++){
            tallList[i] = scan.nextInt();
        }

        System.out.println(mySol(n, tallList));
    }

    private static int mySol(int n, int[] tallList) {
        int result = 0;
        int minTall = 0;
        for(int i=0;i<n;i++){
            if(tallList[i] > minTall){
                result++;
                minTall = tallList[i];
            }
        }

        return result;
    }
}
