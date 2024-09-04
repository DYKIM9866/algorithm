package online.twoweeks.base.prefixsum;

import java.util.Scanner;

/**
 * 백준
 * 연속합
 * 실버 2
 */
public class No1912 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int sumVal = 0;
        int maxVal = Integer.MIN_VALUE;
        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) {
            int val = scan.nextInt();
            sumVal += val;
            prefix[i] = sumVal;
            maxVal = Math.max(sumVal, maxVal);
            if(sumVal < 0){
                sumVal = 0;
            }
        }

        System.out.println(maxVal);
    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] prefix = new int[n];
//        int prefixVal = 0;
//        for (int i = 0; i < n; i++) {
//            int val = Integer.parseInt(st.nextToken());
//            prefixVal += val;
//            if(val > prefixVal){
//                prefixVal = val;
//            }
//            prefix[i] = prefixVal;
//        }
//
//
//        System.out.println(findSum(n, prefix));
//
//    }
//
//    private static int findSum(int n, int[] prefix) {
//        int result = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            result = Math.max(result, prefix[i]);
//        }
//        return result;
//    }
}
