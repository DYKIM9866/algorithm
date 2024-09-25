package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 실버 2
 * 알파벳 블록
 * 앞 뒤 제거가 빠른 LinkedList 를 사용해서 풀이
 * 직전의 값을 제거 할 때는 스택을 만들어서 담아뒀다가 사용
 * 완료
 */
public class No27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<String> bar = new LinkedList<>();
        Deque<Boolean>  flag = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");
            if(command[0].equals("1")){
                bar.addLast(command[1]);
                flag.push(false);
            }else if(command[0].equals("2")){
                bar.addFirst(command[1]);
                flag.push(true);
            }else{
                if(bar.isEmpty()) continue;
                if(flag.pop()){
                    bar.removeFirst();
                }else{
                    bar.removeLast();
                }
            }
        }
        if(bar.isEmpty()) System.out.println(0);
        else {
            StringBuilder sb = new StringBuilder();
            for(String s : bar){
                sb.append(s);
            }
            System.out.println(sb);
        }
    }
}
