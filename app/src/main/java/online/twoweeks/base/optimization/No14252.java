package online.twoweeks.base.optimization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준
 * 공약수열
 * 플래티넘 4
 */
public class No14252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        while(n --> 0){
            list.add(Integer.valueOf(st.nextToken()));
        }

        list.sort(Comparator.naturalOrder());

        System.out.println(findAdd(n, list));
    }

    private static int findAdd(int n, List<Integer> list) {
        int result = 0;

        for (int i = 0; i < list.size() - 1; i++) {
            int a = list.get(i);
            int b = list.get(i+1);
            if(euclidean(a, b) != 1){
                for(int j=a+1;j<b;j++){
                    if(euclidean(a,j) == 1 && euclidean(b,j) == 1){
                        result += 1;
                        break;
                    }
                    if(j == b-1) result += 2;
                }
            }
        }

        return result;
    }

    private static int euclidean(int a, int b) {
        int r = a % b;
        if(r == 0){
            return b;
        }

        return euclidean(b, r);
    }
}
