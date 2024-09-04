package online.judge.leets;

public class LeetsNo63 {
    public static void main(String[] args) {
        LeetsNo63Solution sol = new LeetsNo63Solution();
//        sol.uniquePathsWithObstacles(new int[][]{{0,0},{0,1}});
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(sol.uniquePathsWithObstacles(new int[][]{{0}}));

    }

}
class LeetsNo63Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        //시작점, 도착점이 장애물이면 불가능
        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1) return 0;

        int x = 1;
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0] == 1) x = -1;
            obstacleGrid[i][0] = x;
        }
        x = 1;
        for(int i=1;i<n;i++){
            if(obstacleGrid[0][i] == 1) x = -1;
            obstacleGrid[0][i] = x;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                int up = obstacleGrid[i-1][j] == -1 ? 0 : obstacleGrid[i-1][j];
                int left = obstacleGrid[i][j-1] == -1 ? 0 : obstacleGrid[i][j-1];

                obstacleGrid[i][j] = up + left;
            }
        }

        return obstacleGrid[m-1][n-1];
    }
}