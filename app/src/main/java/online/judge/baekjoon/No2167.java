package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 실버 5
 * 2차원 배열의 합
 * 그냥 구현으로 풀리는 문제지만 속도가 느려서 누적합으로 풀이 추가
 * 완료
 */
public class No2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        int[][] grid = new int[n+1][m+1];
        int[][] prefix = new int[n+1][m+1];

        for(int i=1;i<n+1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<m+1;j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
                //왼쪽 상단에서부터 해당 인덱스까지의 합
                //위, 왼 더하고 겹치는 부분인 대각선 왼쪽 빼주기
                prefix[i][j] = grid[i][j] + prefix[i-1][j] + prefix[i][j-1]
                        - prefix[i-1][j-1];
            }
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<k;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            //누적해서 더해져 있기 때문에 왼쪽 위 각 꼭지점 값들 빼주고
            // 두번 빼준 왼쪽 꼭짓점 값 더해주기
            int sum = prefix[e][r] - prefix[e][w-1] - prefix[q-1][r] + prefix[q-1][w-1];

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }

    //정답이지만 오래걸림
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] nm = br.readLine().split(" ");
//        int n = Integer.parseInt(nm[0]);
//        int m = Integer.parseInt(nm[1]);
//
//        int[][] grid = new int[n][m];
//
//        for(int i=0;i<n;i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for(int j=0;j<m;j++){
//                grid[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        int k = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        for(int i=0;i<k;i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int q = Integer.parseInt(st.nextToken())-1;
//            int w = Integer.parseInt(st.nextToken())-1;
//            int e = Integer.parseInt(st.nextToken())-1;
//            int r = Integer.parseInt(st.nextToken())-1;
//            int sum = 0;
//
//            for(int j=q;j<=e;j++){
//                for(int l=w;l<=r;l++){
//                    sum += grid[j][l];
//                }
//            }
//            sb.append(sum).append("\n");
//        }
//
//        System.out.println(sb);
//    }
}
