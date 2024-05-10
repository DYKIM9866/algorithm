package online.taewon.section5_stack_que;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주_구하기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        System.out.println(classSol(n,k));
    }
    private static int mySol(int n, int k) {
        int result = 0;
        int[] prince = new int[n+1];
        prince[0] = 1;
        int countOne = 0;
        int index = 1;
        int speak = 0;

        while(countOne < n-1){
            if(index == n+1){
                index = 1;
            }
            if(prince[index] != 1){
                speak++;
                if(speak == k){
                    prince[index] = 1;
                    countOne++;
                    speak = 0;
                }
            }

            index++;
        }
        for(int i=0;i<n+1;i++){
            if(prince[i] == 0){
                result = i;
                break;
            }
        }

        return result;
    }

    private static int classSol(int n, int k){
        int result = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i=1;i<=n;i++){
            que.offer(i);
        }
        while(!que.isEmpty()){
            for(int i=1;i<k;i++){
                que.offer(que.poll());
            }
            que.poll();
            if(que.size() == 1) result = que.poll();
        }

        return result;
    }
}
