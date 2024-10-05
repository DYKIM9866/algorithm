package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 카드 문자열
 * 실버 3
 */
public class No13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            LinkedList<Character> list = new LinkedList<>();

            list.add(st.nextToken().charAt(0));

            while(st.hasMoreTokens()){
                char temp = st.nextToken().charAt(0);
                if(list.get(0) >= temp){
                    list.addFirst(temp);
                }else{
                    list.addLast(temp);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(list.get(i));
            }
            System.out.println(sb);
        }
    }
}
