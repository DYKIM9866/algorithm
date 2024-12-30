package online.judge.programmers;

public class 신규_아이디_추천 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution.solution("z-+.^."));
        System.out.println(solution.solution("=.="));
        System.out.println(solution.solution("123_.def"));
        System.out.println(solution.solution("abcdefghijklmn.p"));

    }

    static class Solution {
        public String solution(String new_id) {
            /**
             * 1. 소문자 변경
             * 2. . _ -를 제외하고 없애기
             * 3. 반복되는 . 있으면 하나로 줄이기
             * 4. 앞 뒤로 . 있으면 지우기
             */
            String answer = new_id.toLowerCase()
                    .replaceAll("[^a-z0-9-._]", "")
                    .replaceAll("([.])\\1+", "$1")
                    .replaceAll("^[.]+", "")
                    .replaceAll("[.]+$", "");

            //5. 빈 문자열이 되어버렸으면 a 넣음
            if (answer.isEmpty()) {
                answer = "a";
            }

            //6. 문자열의 길이가 16이상이면 15개로 자르고 끝에 위치하는 . 제거
            if(answer.length() >= 16){
                answer = answer.substring(0,15);
            }
            answer = answer.replaceAll("[.]+$", "");

            //7. 문자열의 길이가 2자 이하라면, 문자열의 길이가 3이 될 때까지 마지막 문자 추가
            if(answer.length() <= 2){
                StringBuilder sb = new StringBuilder(answer);
                while(sb.length() < 3){
                    sb.append(sb.charAt(sb.length()-1));
                }
                answer = sb.toString();
            }

            return answer;
        }
    }
}
