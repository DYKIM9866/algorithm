package online.judge.baekjoon;

import java.util.*;

/**
 * 게임 닉네임
 * 골드 3
 */
public class No16934 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        Map<String,Integer> ids = new HashMap<>();
        Set<String> nicknames = new HashSet<>();

        StringBuilder answer = new StringBuilder();
        while(n-->0){
            String id = scan.nextLine();
            Integer temp = ids.get(id);
            StringBuilder sb = new StringBuilder();
            if(temp != null){
                ids.put(id,temp + 1);
                answer.append(id).append(temp+1).append("\n");
            }else{
                ids.put(id, 1);
                boolean flag = true;
                for (int i = 0; i < id.length(); i++) {
                    sb.append(id.charAt(i));
                    if(!nicknames.contains(sb.toString()) && flag){
                        answer.append(sb).append("\n");
                        flag = false;
                    }
                    nicknames.add(sb.toString());
                }
                if(flag){
                    answer.append(id).append("\n");
                }
            }
        }
        System.out.println(answer);
    }
}
