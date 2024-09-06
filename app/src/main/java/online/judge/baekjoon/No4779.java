package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 3
 * 칸토어 집합
 * 재귀로 풀려고 하다가 시간초과가 발생해서 DP 로 변경해서 풀이
 */
public class No4779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
//        while((input = br.readLine()) != null && !input.isEmpty()){
//            int n = Integer.parseInt(input);
//            char[] arr = new char[(int) Math.pow(3, n)];
//            for(int i=0;i<arr.length;i++){
//                arr[i] = '-';
//            }
//            cantor(arr,0,arr.length-1, n);
//            for(char chr : arr){
//                System.out.print(chr);
//            }
//        }
        String[] strArr = new String[13];
        strArr[0] = "-";
        for(int i=1;i<13;i++){
            strArr[i] = strArr[i-1] + " ".repeat(strArr[i-1].length()) + strArr[i-1];
        }
        while((input = br.readLine()) != null && !input.isEmpty()){
            int n = Integer.parseInt(input);
            System.out.println(strArr[n]);
        }
    }

    private static void cantor(char[] arr,int start, int end, int n) {
        if(n == 0) return;
        int mark = (int) Math.pow(3, n-1);
        for(int i=start + mark;i<=start+(mark*2)-1;i++){
            arr[i] = ' ';
        }
        cantor(arr, start, start + mark-1, n-1);
        cantor(arr, start + mark*2, end, n-1);
    }
}
