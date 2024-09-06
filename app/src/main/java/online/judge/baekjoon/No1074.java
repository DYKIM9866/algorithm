package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 1
 * Z
 * 완료
 */
public class No1074 {
    private static int[] dx = {0,0,1,1};
    private static int[] dy = {0,1,0,1};
    private static long cnt = 0;
    private static int r;
    private static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nrc = br.readLine().split(" ");
        int n = Integer.parseInt(nrc[0]);
        r = Integer.parseInt(nrc[1]);
        c = Integer.parseInt(nrc[2]);

        recursion(n, 0, 0);
    }

    private static void recursion(int n, int x, int y) {
        if(n == 1){
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx == r && ny == c){
                    System.out.println(cnt);
                    return;
                }
                cnt++;
            }
            return;
        }
        int z = (int) Math.pow(2,n-1);
//        if(r >= x && r < x+z && c >= y && c < y+z){
//            recursion(n-1, x, y);
//        }else{
//            cnt += z * z;
//        }
//
//        if(r >= x && r < x+z && c >= x+z && c <y + 2*z){
//            recursion(n-1, x, y + z);
//        }else{
//            cnt += z*z;
//        }
//
//        if(r >= x+z && r < x + 2*z && c >= y && c < y+z){
//            recursion(n-1, x+z, y);
//        }else{
//            cnt += z*z;
//        }
//
//        if(r >= x+z && r < x + 2*z && c >= x+z && c <y+ 2*z){
//            recursion(n-1, x+z,y+z);
//        }else{
//            cnt += z*z;
//        }
        // 1사분면
        if (r < x + z && c < y + z) {
            recursion(n - 1, x, y);
        }
        // 2사분면
        else if (r < x + z && c >= y + z) {
            cnt += z * z;
            recursion(n - 1, x, y + z);
        }
        // 3사분면
        else if (r >= x + z && c < y + z) {
            cnt += 2 * z * z;
            recursion(n - 1, x + z, y);
        }
        // 4사분면
        else {
            cnt += 3 * z * z;
            recursion(n - 1, x + z, y + z);
        }

    }
}
