package online.taewon.section7;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * DFS, BFS 통합
 */

public class Tree말단노드까지의_가장_짧은_경로 {
    static Node root;

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        System.out.println(DFS(0, root));
        System.out.println(BFS());
    }

    private static int BFS() {
        Deque<Node> que = new ArrayDeque<>();
        que.offer(root);
        int level = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                Node node = que.poll();
                if(node.lt == null && node.rt == null) return level;
                if(node.lt != null) que.offer(node.lt);
                if(node.rt != null) que.offer(node.rt);
            }
            level++;
        }
        return 0;
    }

    private static int DFS(int level,Node node) {
        if (node.lt == null && node.rt == null) return level;
        else return Math.min(DFS(level + 1, node.lt), DFS(level + 1, node.rt));
    }

}

