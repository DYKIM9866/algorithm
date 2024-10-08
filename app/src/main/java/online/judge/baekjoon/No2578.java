package online.judge.baekjoon;

import java.util.*;

/**
 * 빙고
 * 실버 4
 */
public class No2578 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] bingoBoard = new int[5][5];
        Map<Integer, int[]> idxExplain = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int temp = scan.nextInt();
                idxExplain.put(temp, new int[]{i,j});
                bingoBoard[i][j] = temp;
            }
        }

        for (int i = 0; i < 11; i++) {
            int temp = scan.nextInt();
            int[] grid = idxExplain.get(temp);
            bingoBoard[grid[0]][grid[1]] = -1;
        }

        for (int i = 12; i <= 25; i++) {
            int temp = scan.nextInt();
            int[] grid = idxExplain.get(temp);
            bingoBoard[grid[0]][grid[1]] = -1;
            if(checkBingo(bingoBoard)){
                System.out.println(i);
                break;
            }
        }

    }

    private static boolean checkBingo(int[][] bingoBoard) {
        int bingo = 0;
        //행 검사
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if(bingoBoard[i][j] == -1) cnt++;
            }
            if(cnt == 5) bingo++;
        }
        if(bingo >= 3) return true;

        //열 검사
        for (int i = 0; i < 5; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if(bingoBoard[j][i] == -1) cnt++;
            }
            if(cnt == 5) bingo++;
        }
        if(bingo >= 3) return true;

        int[][] dia1 = {{0,4}, {1, 3}, {2, 2},{3,1},{4,0}};
        int[][] dia2 = {{0,0}, {1, 1}, {2, 2},{3,3},{4,4}};

        //대각 검사
        int cnt1 = 0;
        int cnt2 = 0;
        for (int i = 0; i < 5; i++) {
            int[] grid1 = dia1[i];
            if(bingoBoard[grid1[0]][grid1[1]] == -1) cnt1++;

            int[] grid2 = dia2[i];
            if(bingoBoard[grid2[0]][grid2[1]] == -1) cnt2++;
        }
        if(cnt1 == 5) bingo++;
        if(cnt2 == 5) bingo++;

        return bingo >= 3;
    }

}
