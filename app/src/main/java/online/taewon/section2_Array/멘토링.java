package online.taewon.section2_Array;

import java.util.Scanner;

public class 멘토링 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] grade = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grade[i][j] = scan.nextInt();
            }
        }

        System.out.println(mySol(n,m,grade));
    }

    private static int mySol(int n, int m, int[][] grade) {
        int result = 0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i == j) continue;
                boolean flag = true;
                for(int k=0;k<m;k++){
                    int iPlace = 0;
                    int jPlace = 0;
                    for(int l=0;l<n;l++){
                        if(grade[k][l] == i) iPlace = l;
                        else if(grade[k][l] == j) jPlace =l;
                    }
                    if(iPlace > jPlace){
                        flag=false;
                        break;
                    }
                }
                if(flag) result++;
            }
        }

        return result;
    }
}
