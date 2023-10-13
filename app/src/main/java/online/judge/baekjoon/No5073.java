package online.judge.baekjoon;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 삼각형과 세 변
 * 완료 231005
 */
public class No5073 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            StringTokenizer st = new StringTokenizer(scan.nextLine());
            int[] intArr = new int[3];
            intArr[0] = Integer.parseInt(st.nextToken());
            intArr[1] = Integer.parseInt(st.nextToken());
            intArr[2] = Integer.parseInt(st.nextToken());
            if(intArr[0] == 0 && intArr[1] == 0 && intArr[2] == 0){
                break;
            }
            for(int i=0;i<2;i++){
                if(intArr[i] > intArr[i+1]){
                    int temp = intArr[i];
                    intArr[i] = intArr[i+1];
                    intArr[i] = temp;
                }
            }
            if(intArr[2] >= intArr[0] + intArr[1]){
                System.out.println("Invalid");
            }else if(intArr[0] == intArr[1] && intArr[1] == intArr[2]){
                System.out.println("Equilateral");
            }else if((intArr[0] == intArr[1] && intArr[1] != intArr[2] )
                || (intArr[0] == intArr[2] && intArr[2] != intArr[1] )
                || (intArr[1] == intArr[2] && intArr[2] != intArr[0]) ){
                System.out.println("Isosceles");
            }else{
                System.out.println("Scalene");
            }
        }
    }
}
