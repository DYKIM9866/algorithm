package online.judge.baekjoon;

import java.util.Map;
import java.util.Scanner;

/**
 * 중앙 이동 알고리즘
 * 완료 231005
 */
public class No2903 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a = 2;
        for(int i=0;i<n;i++){
            a += pow(2,i);
        }
        System.out.println(a*a);
    }

    private static int pow(int n, int count) {
        if(count == 0){
            return 1;
        }
        if(count == 1){
            return n;
        }
        for(int i=1;i<count;i++){
            n*=2;
        }
        return n;
    }


}
