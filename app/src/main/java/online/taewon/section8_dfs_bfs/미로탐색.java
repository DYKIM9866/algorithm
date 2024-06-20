package online.taewon.section8_dfs_bfs;

import java.util.Scanner;

public class 미로탐색 {
    static int result;
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


            miro[0][0] = 1;
            findRoad(0, 0);
            System.out.println(result);
        }
    }

    private static void findRoad(int x, int y) {
        if(x == 6 && y == 6) result++;
        else{
            for (int i = 0; i < 4; i++) {
                int dx = x + roadX[i];
                int dy = y + roadY[i];
                if(dx < 0 || dy < 0 || dx >= 7 || dy >= 7) continue;
                else{
                    if(miro[dx][dy] == 0){
                        miro[dx][dy] = 1;
                        findRoad(dx,dy);
                        miro[dx][dy] = 0;
                    }
                }
            }
        }
    }
}
