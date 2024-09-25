package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


/**
 * 실버 4
 * 덱
 * 완료?
 */
public class No10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> deque = new LinkedList<>();

        for(int i=0;i<n;i++){
            String[] command = br.readLine().split(" ");
            switch (command[0]){
                case "push_back" :
                    deque.addLast(Integer.valueOf(command[1]));
                    break;
                case "push_front" :
                    deque.addFirst(Integer.valueOf(command[1]));
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.removeFirst());
                    break;
                case "pop_back" :
                    if(deque.isEmpty()){
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.removeLast());
                    break;
                case "front" :
                    if(deque.isEmpty()){
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.getFirst());
                    break;
                case "back":
                    if(deque.isEmpty()){
                        System.out.println(-1);
                        break;
                    }
                    System.out.println(deque.getLast());
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    if(deque.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
            }
        }


    }
}
