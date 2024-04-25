package online.taewon.section3_two_pointer_sliding_window;

import java.util.Scanner;

/**
 * sorting 필요.. 넘어감
 */
public class 공통원소_구하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] checkArr = new int[30_001];
        for(int i=0;i<n;i++){
            int tmp = scan.nextInt();
            checkArr[tmp] += 1;
        }
        int m = scan.nextInt();
        for(int i=0;i<m;i++){
            int tmp = scan.nextInt();
            checkArr[tmp] += 1;
        }

        System.out.println(mySol(n,m,checkArr));
    }

    private static String mySol(int n, int m, int[] checkArr) {
        String result = "";
        for(int i=1;i<=30001;i++){
            if(checkArr[i] == 2){
                result += i + " ";
            }
        }

        return result;
    }
}
