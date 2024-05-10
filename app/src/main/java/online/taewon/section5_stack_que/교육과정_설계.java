package online.taewon.section5_stack_que;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정_설계 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String essen = scan.nextLine();
        String classList = scan.nextLine();

        System.out.println(mySol(essen,classList));
    }

    private static String mySol(String essen, String classList) {
        String result = "NO";
        Queue<Character> que = new LinkedList<>();
        for (char chr : essen.toCharArray()) {
            que.offer(chr);
        }

        for(char lesson : classList.toCharArray()){
            if(que.size() == 0){
                result = "YES";
                break;
            }
            if(que.peek() == lesson){
                que.poll();
            }
        }

        return result;
    }
}
