package online.taewon.section4_hashmap_treeset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 시간초과 나는 이유를 모르겠음
 */
public class 매출액의_종류 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nk = br.readLine();
        int n = Integer.parseInt(nk.split(" ")[0]);
        int k = Integer.parseInt(nk.split(" ")[1]);
        String[] intArr = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(intArr[i]);
        }

        System.out.println(mySol(n,k,arr));
    }

    private static String mySol(int n, int k, int[] arr) {
        String result = "";
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<k-1;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        }

        int lt = 0;
        for(int rt=k-1;rt<n;rt++){
            map.put(arr[rt],map.getOrDefault(arr[rt],0) + 1);
            result += map.size() + " ";
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if(map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        return result;
    }
}
