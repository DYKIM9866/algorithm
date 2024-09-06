package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 팰린드롬 파티션
 * dp로 해결해야 함
 * 1의 경우 1 = 1
 * 2의 경우 n(1) n(1), 2 = 2
 * 3의 경우 n(1) 1 n(1), 3 = 2
 * 4의 경우 n(2) n(2), n(1) 2 n(1), 4 = 4
 * 5의 경우 n(2) 1 n(2),n(1) 3 n(1), 5 = 4
 * 6의 경우 n(3) n(3),n(2) 2 n(2), n(1) 4 n(1), 6 = 6
 * 7의 경우 n(3) 1 n(3),n(2) 3 n(2), n(1) 5 n(1), 7 = 6
 * 8의 경우 n(4) n(4), n(3) 2 n(3), n(2) 4 n(2), n(1) 6 n(1),8 = 10
 * 9의 경우 n(4) 1 n(4), n(3) 3 n(3), n(2) 5 n(2)m, n(1) 7 n(1), 9 = 10
 * 완료
 */
public class No2705 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=1000;i++){
            if(i%2 == 0){
                for(int j=1;j<=i/2;j++){
                    dp[i] += dp[j];
                }
                dp[i]++;
            }else{
                dp[i] = dp[i-1];
            }
        }
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
