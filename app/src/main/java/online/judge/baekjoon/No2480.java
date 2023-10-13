package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 주사위 세개
 * 완료
 */
public class No2480 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int dice1 = scan.nextInt();
        int dice2 = scan.nextInt();
        int dice3 = scan.nextInt();
        int result = 0;
        if(dice1 == dice2 && dice2 == dice3 && dice1 == dice3){
            result += (dice1*1_000) + 10_000;
        }else if (dice1 == dice2){
            result += (dice1*100) + 1_000;
        }else if (dice2 == dice3){
            result += (dice2*100) + 1_000;
        }else if (dice1 == dice3){
            result += (dice3*100) + 1_000;
        }else{
            result += Math.max(dice1,Math.max(dice2,dice3)) * 100;
        }

        System.out.println(result);
    }
}
