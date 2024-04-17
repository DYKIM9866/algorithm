package online.hanghae99;

public class March27 {
    public static void main(String[] args) {

    }

    /**
     * 프로그래머스
     * 정수 제곱근 판별
     */
    private static long solution(long n){
        double x = Math.sqrt(n);
        if(x*10%10 != 0){
            return -1L;
        }else{
            return (long)((x+1) * (x+1));
        }
    }
}
