package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열
 * 실버 2
 */
public class No11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int[] lis = new int[n];
        lis[0] = arr[0];

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            if(lis[idx] < temp){
                lis[++idx] = temp;
            }else{
                int lt = 0;
                int rt = idx;
                while(lt < rt){
                    int mid = (lt + rt)/2;
                    if(lis[mid] < temp){
                        lt = mid + 1;
                    }else{
                        rt = mid;
                    }
                }
                lis[rt] = temp;
            }
        }

        System.out.println(idx+1);
    }
}
