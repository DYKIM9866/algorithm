package online.judge.leets;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 1091. Shortest Path in Binary Matrix
 *
 * 문제 해석
 *
 * 1. nxn 크기의 grid가 주어진다.
 * 2. 0,0 에서 출발하여 n-1,n-1 까지 최단경로를 구하면 된다.
 * 3. 이동할 수 있는 곳은 8방향이다.
 *
 * 문제 풀이
 * 1. 최단 거리 문제니까 기본 BFS로 풀이
 */
public class LeetNo1091 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPathBinaryMatrix(
                new int[][]{
                        {0,1},{1,0}
                }
        ));
    }
    static class Solution {
        int[] dx = {1,0,-1,0,1,-1,1,-1};
        int[] dy = {0,1,0,-1,1,-1,-1,1};
        public int shortestPathBinaryMatrix(int[][] grid) {
            //출발조차 못함
            if(grid[0][0] == 1) return -1;

            int n = grid.length;
            Queue<int[]> que = new ArrayDeque<>();
            int[][] visited = new int[n][n];

            //초기값
            for(int i=0;i<n;i++){
                Arrays.fill(visited[i],Integer.MAX_VALUE);
            }
            visited[0][0] = 1;
            que.offer(new int[]{0,0,1}); //x, y, depth

            while(!que.isEmpty()){
                int[] cur = que.poll();
                int x = cur[0];
                int y = cur[1];
                int d = cur[2];

                for(int i=0;i<8;i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if(nx < 0 || ny < 0 || nx >= n || ny >= n
                            ||grid[nx][ny] == 1 || visited[nx][ny] != Integer.MAX_VALUE) continue;

                    visited[nx][ny] = d + 1;
                    que.offer(new int[]{nx,ny,d+1});
                }
            }

            if(grid[n-1][n-1] == Integer.MAX_VALUE) return -1;
            else return grid[n-1][n-1];
        }
    }
}
