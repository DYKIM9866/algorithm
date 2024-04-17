package online.hanghae99;

public class April16 {
    public static void main(String[] args) {
    }

    /**
     * 프로그래머스
     * 약수의 합
     */
    private static int solution(int n){
        int answer = 0;
        for(int i=1;i<=n/2;i++){
            if(n%i == 0){
                answer += i;
            }
        }
        answer += n;

        return answer;
    }
}
