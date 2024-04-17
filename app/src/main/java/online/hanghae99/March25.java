package online.hanghae99;

/**
 * 3월 25일
 */
public class March25 {
    public static void main(String[] args) {

    }

    /**
     * 프로그래머스
     * 서울에서 김서방 찾기
     */
    private static String solution(String[] seoul){
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")){
                return "김서방은 " + i + "에 있다";
            }
        }
        return "";
    }

    /**
     * 프로그래머스
     * 수박수박수박수박수박수?
     */
    private static String solution2(int n){
        String answer = "";
        for(int i=1;i<n+1;i++){
            if(i%2 == 0){
                answer += "박";
            }else{
                answer += "수";
            }
        }
        return answer;
    }
}
