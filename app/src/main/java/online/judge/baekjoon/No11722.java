package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 감소하는 부분 수열
 * 실버 2
 */
public class No11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        int[] lds = new int[n];
        lds[0] = arr[0];
        for (int i = 1; i < n; i++) {
            if(lds[idx] > arr[i]){
                lds[++idx] = arr[i];
            }else{
                int lt = 0;
                int rt = idx;
                while(lt < rt){
                    int mid = (lt + rt) / 2;
                    if(lds[mid] > arr[i]){
                        lt = mid + 1;
                    }else{
                        rt = mid;
                    }
                }
                lds[rt] = arr[i];
            }
        }

        System.out.println(idx+1);
    }
}
