package online.hanghae99;

/**
 * 3월 29일
 */
public class March29 {
    public static void main(String[] args) {

    }

    /**
     * 프로그래머스
     * 부족한 금액 계산하기
     */
    private static long solution(int price, int money, int count){
        long pay = 0;
        for(int i=1;i<=count;i++){
            pay += price * i;
        }
        long answer = pay - money;
        if(answer < 0) answer =0;
        return answer;
    }
}
