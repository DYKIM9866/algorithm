package online.judge.baekjoon;

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 중량제한
 * 골드 3
 */
public class No1939 {

    static int n;
    static int m;
    static Node[] nodes;
    static int answer=Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new Node[n+1];

        //각 섬 초기화
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node();
            nodes[i].network = new ArrayList<>();
        }

        //섬 연결 받기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            //양방향
            nodes[a].network.add(new int[]{b,c});
            nodes[b].network.add(new int[]{a,c});
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());

        bfs(start, arrive);

        System.out.println(nodes[arrive].value);
    }

    private static void bfs(int start, int arrive) {
        Queue<Integer> que = new ArrayDeque<>();

        nodes[start].confirm = true;
        que.offer(start);

        while (!que.isEmpty()) {
            int current = que.poll();
            for(int[] net : nodes[current].network){
                Node node = nodes[net[0]];

                if(node.confirm) continue;
                if(node.value == 0){
                    node.value = net[1];
                }else{
                    node.value = Math.max(net[1],node.value);
                }
                if(net[0] != arrive){
                    que.offer(net[0]);
                }
            }
        }
    }

    static class Node{
        int value;
        boolean confirm;
        List<int[]> network;
    }


}
