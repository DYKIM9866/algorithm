package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 줈 ㅔ우기
 * 골드 4
 */
public class No2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
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

        System.out.println(n - (idx + 1));
    }
}
