package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 선분 위의 점
 * 실버
 */
public class No11663 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);


        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            answer.append(binarySearch(a,b,arr))
                    .append("\n");
        }

        System.out.println(answer);
    }

    private static int binarySearch(int a, int b, int[] arr) {
        //lower bound
        int left = 0;
        int right = arr.length;

        while(right > left){
            int mid = (right + left) / 2;
            if(arr[mid] < a){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        int low = right;

        //upper bound
        left = 0;
        right = arr.length;

        while(right > left){
            int mid = (right + left) / 2;
            if(arr[mid] <= b){
                left = mid+1;
            }else{
                right = mid;
            }
        }

        int high = right;
        return high - low;
    }
}
