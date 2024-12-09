package online.judge.leets;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Coin Change
 *
 * 문제 해석
 *
 * 1. 코인 리스트와 숫자가 주어진다.
 * 2. 코인 리스트에 있는 코인을 가지고 숫자를 완성시킬 수 있는지 알아보는 문제이다.
 * 3. 만들 수 없다면 -1을 출력하고 만들 수 있다면 얼마나 가장 적은 개수로 만들 수 있는지 출력하면 된다.
 * 4. 코인은 무한대로 사용가능하다.
 *
 * 문제 풀이
 *
 * 1. amount가 만들어지는 모든 경우의 수를 찾는 완탐은 시간 초과가 발생함
 * 2. bfs를 사용하면서 만들었던(이미 들렸던) 코인은 넘어가면서 풀이
 */
public class LeetNo322 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
    }

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            if(amount == 0) return 0;
            Queue<int[]> que = new ArrayDeque<>();
            boolean[] visited = new boolean[amount+1];

            que.offer(new int[]{0,0}); //depth, cnt

            while(!que.isEmpty()){
                int[] cur = que.poll();
                int d = cur[0];
                int c = cur[1];
                for(int coin : coins){
                    int nc = c + coin;
                    if(nc == amount) return d + 1;
                    if(nc > amount || visited[nc]) continue;
                    visited[nc] = true;
                    que.offer(new int[]{d+1, nc});
                }
            }

            return -1;
        }
    }
}
