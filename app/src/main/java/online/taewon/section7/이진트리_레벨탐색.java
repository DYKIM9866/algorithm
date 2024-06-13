package online.taewon.section7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class 이진트리_레벨탐색 {
    static Deque<Integer> que = new ArrayDeque<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            que.offer(i);
        }

        BFS();
    }

    private static void BFS() {
        while (que.size() > 0) {
            System.out.print(que.poll() + " ");
        }
    }
}

