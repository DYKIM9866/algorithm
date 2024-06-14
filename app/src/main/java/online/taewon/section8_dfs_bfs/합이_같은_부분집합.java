package online.taewon.section8_dfs_bfs;

import java.util.*;

public class 합이_같은_부분집합 {
    static int n;
    static int[] arr;
    static boolean flag = true;
    static Map<Integer, Integer> check = new LinkedHashMap<>();
    static String result = "NO";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            check.put(arr[i], 0);
        }

        check.put(arr[0], 1);
        DFS();
        System.out.println(result);
    }

    private static void DFS() {
        if (flag == false) {
            return;
        }
        int sum0 = 0;
        int sum1 = 0;
        for (int i = 0; i <n; i++) {
            if (check.get(arr[i]) == 1) sum1 += arr[i];
            else sum0 += arr[i];
        }
        if (sum0 == sum1){
            flag = false;
            result = "YES";
        }
        else {
            for (int i = 0; i < n; i++) {
                if (check.get(arr[i]) == 0) {
                    check.put(arr[i], 1);
                    DFS();
                    check.put(arr[i], 0);
                }
            }
        }
    }

}
