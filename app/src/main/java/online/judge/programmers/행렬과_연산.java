package online.judge.programmers;

public class 행렬과_연산 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] solution1 = solution.solution(new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}
//        }, new String[]{"Rotate", "ShiftRow"});
        int[][] solution2 = solution.solution(new int[][]{
                {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        }, new String[]{"ShiftRow", "Rotate", "ShiftRow", "Rotate"});

//        printArray(solution1);
        printArray(solution2);
    }

    private static void printArray(int[][] solution1) {
        for (int i = 0; i < solution1.length; i++) {
            for (int j = 0; j < solution1[1].length; j++) {
                System.out.print(solution1[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] solution(int[][] rc, String[] operations) {
            int r = rc.length;
            int c = rc[0].length;

            for(String opt : operations){
                if(opt.equals("ShiftRow")){
                    int[] lastRow = rc[r-1];
                    for(int i= r-1;i>0;i--){
                        rc[i] = rc[i-1];
                    }
                    rc[0] = lastRow;
                }else{
                    int[][] tempRc = pushOut(rc,r,c);
                    insertRc(rc, tempRc,r,c);
                }
            }

            return rc;
        }

        private void insertRc(int[][] rc, int[][] tempRc, int r, int c){
            //상단행
            for(int i=0;i<c;i++){
                rc[0][i] = tempRc[1][i+1];
            }
            //우측 열
            for(int i=0;i<r;i++){
                rc[i][c-1] = tempRc[i+1][c];
            }
            //하단 행
            for(int i=0;i<c;i++){
                rc[r-1][i] = tempRc[r][i+1];
            }
            //좌측 열
            for(int i=0;i<r;i++){
                rc[i][0] = tempRc[i+1][1];
            }
        }

        private int[][] pushOut(int[][] rc, int r, int c){
            int[][] tempRc = new int[r+2][c+2];

            //상단행
            for(int i=0;i<c;i++){
                tempRc[1][i+2] = rc[0][i];
            }
            //우측 열
            for(int i=0;i<r;i++){
                tempRc[i+2][c] = rc[i][c-1];
            }
            //하단 행
            for(int i=0;i<c;i++){
                tempRc[r][i] = rc[r-1][i];
            }
            //좌측 열
            for(int i=0;i<r;i++){
                tempRc[i][1] = rc[i][0];
            }
            return tempRc;
        }
    }
}
