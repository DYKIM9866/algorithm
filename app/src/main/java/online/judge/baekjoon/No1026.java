package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 보물
 * 실버 4
 * 문제 풀이
 * 1. 길이가 같은 두 개의 배열이 입력으로 주어진다.
 * 2. 함수 S는 두 배열의 각 인덱스의 곱의 합이다.
 * 3. 합이 가장 작게 되도록 배열을 정렬해라
 *
 * 풀이
 * 1. 각각 오름차순으로 정리 한다.
 * 2. N만큼 반복문을 돌면서 A배열은 0부터 B배열은 N-1부터 곱해서 더해준다..
 */
public class No1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] a = new int[n];
        int[] b = new int[n];

        StringTokenizer aArr = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(aArr.nextToken());
        }

        StringTokenizer bArr = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(bArr.nextToken());
        }

        int answer =
//        useArraysSort(n,a,b);
                useQuickSort(n,a,b);

        System.out.println(answer);
    }

    private static int useQuickSort(int n, int[] a, int[] b) {
        quickSort(0,a.length-1,a);
        quickSort(0,b.length-1,b);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += a[i] * b[n-i-1];
        }
        return answer;
    }

    private static void quickSort(int start, int end, int[] arr) {
        if(start >= end) return;

        int pivot = start;
        int left = start+1;
        int right = end;

        while(left <= right){
            while(left <= end && arr[left] <= arr[pivot]) left++;
            while(right > start && arr[right] >= arr[pivot]) right--;

            if(left > right){
                int temp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = temp;
            }else{
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        quickSort(start, right-1, arr);
        quickSort(right+1, end, arr);
    }


    private static int useArraysSort(int n,int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += a[i] * b[n-i-1];
        }
        return answer;
    }
}
