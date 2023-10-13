package online.judge.baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 세 막대
 */
public class No14215 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());
        int[] intArr = new int[3];
        intArr[0] = Integer.parseInt(st.nextToken());
        intArr[1] = Integer.parseInt(st.nextToken());
        intArr[2] = Integer.parseInt(st.nextToken());

        for(int i=0;i<2;i++){
            if(intArr[i] > intArr[i+1]){
                int temp = intArr[i];
                intArr[i] = intArr[i+1];
                intArr[i+1] = temp;
            }
        }
        while (true){
            if(!test(intArr)){
                intArr[2]--;
            }else{
                break;
            }
        }
        System.out.println(intArr[0] + intArr[1] + intArr[2]);
    }

    private static boolean test(int[] intArr) {
        if(intArr[2] >= intArr[0] + intArr[1]){
            return false;
        }
        return true;
    }
}
