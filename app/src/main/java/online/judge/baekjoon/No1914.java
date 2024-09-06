package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 골드 5
 * 하노이의 탑
 * 하노이의 탑 이동 순서와 같은 문제이지만
 * 값이 커질 수록 급격하게 늘어나기 때문에 BigInteger 사용법을 익혀야 겠다.
 */
public class No1914 {
    private static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[] nArr =  new BigInteger[n+1];
        nArr[0]=new BigInteger("0");
        nArr[1]= new BigInteger("1");
        BigInteger mul = new BigInteger("2");
        for(int i=2;i<=n;i++){
            nArr[i] = nArr[i-1].multiply(mul).add(nArr[1]);
        }

        if(n>20){
            System.out.println(nArr[n]);
        }else{
            hanoi(n, 1, 2, 3);

            StringBuilder sb = new StringBuilder();
            sb.append(list.size()).append("\n");
            for(int[] arr : list){
                sb.append(arr[0]).append(" ").append(arr[1])
                        .append("\n");
            }
            System.out.println(sb);
        }
    }

    private static void hanoi(int n, int start, int mid, int end) {
        if(n == 1){
            list.add(new int[]{start, end});
            return;
        }
        hanoi(n-1, start, end, mid);
        list.add(new int[]{start,end});
        hanoi(n-1, mid, start, end);
    }
}
