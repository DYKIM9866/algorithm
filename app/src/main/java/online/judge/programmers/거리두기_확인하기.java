package online.judge.programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 해석
 * 1. 다섯개의 대기실이 있다.
 * 2. 거리두기를 위해서 맨해튼 거리가 2이하로 앉으면 안된다.
 * 3. 하지만 2이하더라도 사이에 파티션이 있으면 괜찮다.
 * 4. 각 대기실이 거리두기를 잘 하였는지 확인하여 잘 되었으면 1 안되었으면 0을 담아 배열을 return
 *
 * 문제 풀이
 * 1. 대기실 5개 책상 5x5 확인해야 할 곳 12개 최대 1500번 시간 충분 하기 때문에 완탐
 * 2. 대기실 정보 옮겨 담아줌
 * 3. 사람(P)를 발견 했을 경우 확인해야 할 곳 확인
 */

public class 거리두기_확인하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new String[][]
                {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                        {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                        {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});

        for(int i : solution1){
            System.out.print(i + " ");
        }

        solution = new Solution();
        int[] solution2 = solution.solution(new String[][]
                {{"POOOO", "XPOOO", "OOOOO", "OOOOO", "OOOOO"},
                {"OOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOOO"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});

        for(int i : solution2){
            System.out.print(i + " ");
        }
    }
    static class Solution {
        int[] dx1 = {-1, 0, 1, 0};
        int[] dy1 = {0, 1, 0, -1};
        int[] dx2 = {-2, -1, 0, 1, 2, 1, 0, -1};
        int[] dy2 = {0, 1, 2, 1, 0, -1, -2, -1};

        private List<char[][]> transfer(String[][] places){
            List<char[][]> waitingRooms = new ArrayList<>();
            for(int i=0;i<5;i++){
                String[] room = places[i];

                char[][] waiting = new char[5][5];
                for(int j=0;j<5;j++){
                    String str = room[j];
                    for(int k =0;k<5;k++){
                        waiting[j][k] = str.charAt(k);
                    }
                }

                waitingRooms.add(waiting);
            }

            return waitingRooms;
        }
        public int[] solution(String[][] places) {

            // 옮겨 담기
            List<char[][]> waitingRooms = transfer(places);

            //정답 배열
            int idx = 0;
            int[] answer = new int[5];

            for(char[][] waiting : waitingRooms){
                boolean flag = false;
                for(int i=0;i<5;i++){
                    if(flag) break;
                    for(int j=0;j<5;j++){
                        if(waiting[i][j] == 'P'){
                            if(manhattan(waiting, i, j)){
                                flag = true;
                                break;
                            }
                        }
                    }
                }
                if(flag){
                    answer[idx++] = 0;
                }else{
                    answer[idx++] = 1;
                }
            }


            return answer;
        }

        private boolean manhattan(char[][] waiting, int x, int y) {

            //상하좌우
            for(int i=0;i<4;i++){
                int nx = x + dx1[i];
                int ny = y + dy1[i];
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(waiting[nx][ny] == 'P') return true;
            }

            //맨해튼 2
            for(int i=0;i<8;i++){
                int nx = x + dx2[i];
                int ny = y + dy2[i];
                if(nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;
                if(waiting[nx][ny] == 'P'){

                    //수직 수평
                    if(Math.abs(nx - x) == 2 || Math.abs(ny-y) == 2){
                        if(waiting[(x+nx)/2][(y+ny)/2] != 'X') return true;
                    }else{
                        // 대각선
                        if(waiting[x][ny] != 'X' || waiting[nx][y] != 'X') return true;
                    }
                }
            }

            return false;
        }
    }
}
