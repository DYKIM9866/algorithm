package online.taewon.section2_Array;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import java.util.Scanner;

public class 임시반장_정하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] classNum = new int[n][5];
        for(int i=0;i<n;i++){
            for(int j=0;j<5;j++){
                classNum[i][j] = scan.nextInt();
            }
        }

        System.out.println(mySol(n, classNum));
    }

    private static int mySol(int n, int[][] classNum) {
        int result = 0;
        int max = 0;
        for(int i=0;i<n;i++){ //나
            int cnt=0;
            for(int j=0;j<n;j++){//남들
                for(int k=0;k<5;k++){//학년
                    if(classNum[i][k] == classNum[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max){
                max = cnt;
                result = i + 1;
            }
        }

        return result;
    }
}
