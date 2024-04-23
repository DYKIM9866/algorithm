package online.taewon.section2_Array;

import java.util.Scanner;

public class 가위_바위_보 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] aList = new int[n];
        int[] bList = new int[n];
        for(int i=0;i<n;i++){
            aList[i] = scan.nextInt();
        }
        for(int i=0;i<n;i++){
            bList[i] = scan.nextInt();
        }

        System.out.println(mySol(n,aList,bList));
    }

    private static String mySol(int n, int[] aList, int[] bList) {
        String[] result = new String[n];
        String answer = "";
        for(int i=0;i<n;i++){
            if(aList[i] == bList[i]){
                result[i] = "D";
            }else if(aList[i] > bList[i]){
                if(aList[i]-bList[i] == 2){
                    result[i] = "B";
                }else{
                    result[i] = "A";
                }
            }else if(bList[i] > aList[i]){
                if(bList[i]-aList[i] == 2){
                    result[i] = "A";
                }else{
                    result[i] = "B";
                }
            }
        }
        for(int i=0;i<result.length;i++){
            answer += result[i];
            if(i < result.length-1){
                answer += "\n";
            }
        }

        return answer;
    }
}
