package online.hanghae99;

/**
 * 3월 26일
 */
public class March26 {
    public static void main(String[] args) {

    }

    /**
     * 프로그래머스
     * 두 정수 사이의 합
     */
    private static long solution(int a, int b){
        long answer = 0;
        int big, small;
        if(a > b){
            big = a; small = b;
        }else {
            big = b; small = a;
        }

        for(int i=small;i<=big;i++){
            answer += i;
        }
        return answer;
    }
}
