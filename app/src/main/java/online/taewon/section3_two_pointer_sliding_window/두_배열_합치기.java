package online.taewon.section3_two_pointer_sliding_window;

import java.util.Scanner;

public class 두_배열_합치기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nArr = new int[n];
        for(int i=0;i<n;i++){
            nArr[i] = scan.nextInt();
        }
        int m = scan.nextInt();
        int[] mArr = new int[m];
        for(int i=0;i<m;i++){
            mArr[i] = scan.nextInt();
        }

        System.out.println(mySol(n,nArr,m,mArr));
    }

    private static String mySol(int n, int[] nArr, int m, int[] mArr) {
        String answer = "";
        int[] result = new int[n+m];
        int nPoint = 0;
        int mPoint = 0;
        int index = 0;
        while(nPoint != n && mPoint != m){
            if(nArr[nPoint] > mArr[mPoint]){
                result[index++] = mArr[mPoint++];
            }else{
                result[index++] = nArr[nPoint++];
            }
        }

        while(nPoint != n){
            result[index++] = nArr[nPoint++];
        }
        while (mPoint != m){
            result[index++] = mArr[mPoint++];
        }

        for(int x : result){
            answer += x + " ";
        }

        return answer;
    }
}
