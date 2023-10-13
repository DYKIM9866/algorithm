package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 오븐 시계
 * 완료
 */
public class No2525 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] time = scan.nextLine().split(" ");
        int runTime = scan.nextInt();
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]) + runTime;
        if(min >= 60){
            hour += min/60;
            min = min%60;
            if (hour >= 24){
                hour -= 24;
            }
        }
        System.out.println(hour + " " + min);

    }

}
