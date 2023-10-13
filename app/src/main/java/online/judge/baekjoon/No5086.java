package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 배수와 약수
 * 완료 231005
 */
public class No5086 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            String[] strArr = scan.nextLine().split(" ");
            int a = Integer.parseInt(strArr[0]);
            int b = Integer.parseInt(strArr[1]);
            if(a == 0 && b==0){
                break;
            }
            if(b%a == 0){
                System.out.println("factor");
            }else if(a%b == 0){
                System.out.println("multiple");
            }else {
                System.out.println("neither");
            }
        }



    }
}
