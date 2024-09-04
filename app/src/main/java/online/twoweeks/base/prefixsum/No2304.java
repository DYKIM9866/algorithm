package online.twoweeks.base.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준
 * 창고 다각형
 */
public class No2304 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[1001];
        int n = Integer.parseInt(br.readLine());
        int maxHeight = 0;  //최대 높이

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            maxHeight = Math.max(height, maxHeight);

            arr[idx] = height;
        }

        int result = 0; //결과
        int[] maxPoint = new int[2];    //높이가 최대값인 곳의 좌표 양 끝을 저장

        int h = 0;
        for (int i = 0; i <= 1000; i++) {
            if(arr[i] == maxHeight){//최대값과 같으면
                maxPoint[0] = i;    //왼쪽좌표(x좌표 최소)  저장
                break;
            }

            if(h < arr[i]){
                h = arr[i];
            }
            result += h;
        }

        h = 0;
        for (int i = 1000; i >= 0; i--) {
            if(arr[i] == maxHeight){//최대값과 같으면
                maxPoint[1] = i;    //오른쪽좌표(x좌표 최대) 저장
                break;
            }

            if(h < arr[i]){
                h = arr[i];
            }
            result += h;
        }

        //양쪽의 좌표를 빼주고 최대 높이 곱을 더해줌
        result += (maxPoint[1] - maxPoint[0] + 1) * maxHeight;

        System.out.println(result);
    }

}
