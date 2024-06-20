package online.taewon.section8_dfs_bfs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 미로의_최단거리_통로 {
    static int[] roadX = {0,1,0,-1};
    static int[] roadY = {1,0,-1,0};
    static int[][] miro = new int[7][7];
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    int temp = scan.nextInt();
                    miro[i][j] = temp;
                }
            }

            System.out.println(findShortRoad());

        }
    }

    private static int findShortRoad() {
        int result = Integer.MAX_VALUE;

        Deque<int[]> que = new ArrayDeque<>();
        int[] init = {0,0};
        que.offer(init);

        while(!que.isEmpty()){
            int[] tempArr = que.poll();
            int x = tempArr[0];
            int y = tempArr[1];
            if(x == 6 && y == 6){
                if(result > miro[x][y]) result = miro[x][y];
            }else{
                for (int i = 0; i < 4; i++) {
                    int dx = x + roadX[i];
                    int dy = y + roadY[i];
                    if (dx >= 0 && dy >= 0 && dx < 7 && dy < 7 && miro[dx][dy] == 0) {
                        int[] arr = {dx, dy};
                        miro[dx][dy] = miro[x][y] + 1;
                        que.offer(arr);
                    }
                }
            }

        }

        if(result == Integer.MAX_VALUE) result = -1;

        return result;
    }
}
