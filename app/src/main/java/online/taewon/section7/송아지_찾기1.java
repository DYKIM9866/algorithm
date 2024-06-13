package online.taewon.section7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 송아지_찾기1 {
    static int[] dis = {-1, 1, 5};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int e = scan.nextInt();

        System.out.println(mySol(n, e));
    }

    private static int mySol(int n, int e) {
        Deque<Cow> que = new ArrayDeque<>();
        int level = 0;
        int[] check = new int[20_000];
        check[n] = 1;
        que.offer(new Cow(level, n));

        while(!que.isEmpty()){
            Cow thisCow = que.poll();
            if(thisCow.loc == e){
                return thisCow.level;
            }else{
                for (int i = 0; i < 3; i++) {
                    int val = thisCow.loc + dis[i];
                    if(val < 0) continue;
                    if(check[val] != 1){
                        check[val] = 1;
                        que.offer(new Cow(thisCow.level + 1, val));
                    }
                }
            }
        }

        return -1;
    }

    static class Cow{
        int level;
        int loc;

        public Cow(int level, int loc) {
            this.level = level;
            this.loc = loc;
        }
    }
}
