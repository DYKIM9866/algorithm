package online.taewon.section3_two_pointer_sliding_window;

import java.util.Scanner;

public class 연속된_자연수의_합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(mySol(n));
        System.out.println(classSol(n));
    }

    private static int mySol(int n) {
        int result = 0;
        int lt = 1;
        int rt = 1;
        int sum = 0;
        while (rt <= n/2 + 1){
            sum += rt++;
            while(sum >= n){
                if(sum == n) result++;
                sum -= lt++;
            }
        }

        return result;
    }

    /**
     * 수학적 풀이
     */
    private static int classSol(int n){
        int result = 0;
        int cnt = 1;
        n--;
        while(n > 0){
            n -= ++cnt;
            if(n%cnt == 0) result++;
        }

        return result;
    }

}
