package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 약수들의 합
 * 완료 231005
 */
public class No9506 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            int n = scan.nextInt();
            if(n == -1){
                break;
            }

            int sum = 0;
            StringBuilder sb = new StringBuilder();
            StringBuilder result = new StringBuilder();
            result.append(n);

            for(int i=1;i<n;i++){
                if(n%i == 0){
                    sum+=i;
                    sb.append(i + " ");
                }
            }
            if(sum == n){
                result.append(" = ");
                String[] strArr = sb.toString().split(" ");
                for(int i=0;i<strArr.length;i++){
                    result.append(strArr[i]);
                    if(i < strArr.length -1){
                        result.append(" + ");
                    }
                }
            }else{
                result.append(" is NOT perfect.");
            }

            System.out.println(result);
        }

    }
}
