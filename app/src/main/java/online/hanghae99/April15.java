package online.hanghae99;

/**
 * 4월 15일 코딩테스트 문제
 */
public class April15 {
    public static void main(String[] args) {
        System.out.println(solution("AB",1));
        System.out.println(solution("z",1));
        System.out.println(solution("a B z",4));

    }
    public static int[] solution2(int[] arr){
        if(arr.length <= 1){
            return new int[]{-1};
        }
        int[] answer = new int[arr.length -1];
        int min = Integer.MAX_VALUE;
        for(int val : arr){
            if(val < min){
                min = val;
            }
        }

        int index = 0;
        for(int val : arr){
            if(val != min){
                answer[index++] = val;
            }
        }

        return answer;
    }

    public static String solution(String s, int n){
        String answer = "";
        for(char chr: s.toCharArray()){
            if(!Character.isLetter(chr)) {
                return answer+chr;
            }
            if(Character.isUpperCase(chr)){
                chr += n;
                if(chr > 90){
                    answer += (char)(64+(chr-90));
                }else{
                    answer += (char)chr;
                }
            }else{
                chr += n;
                if(chr > 122){
                    answer += (char)(96+(chr-122));
                }else{
                    answer += (char)chr;
                }
            }

        }
        return  answer;
    }
}
