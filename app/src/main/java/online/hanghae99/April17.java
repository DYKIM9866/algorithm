package online.hanghae99;

/**
 * 4월 17일
 */
public class April17 {
    public static void main(String[] args) {

    }

    /**
     * 프로그래머스
     * 내적
     */
    private static int solution(int[] a, int[] b){
        int answer = 0;
        for(int i=0;i<a.length;i++){
            answer += a[i]*b[i];
        }
        return answer;
    }
}
