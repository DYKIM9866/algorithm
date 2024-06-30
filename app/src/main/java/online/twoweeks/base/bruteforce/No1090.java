package online.twoweeks.base.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준
 * 체커
 * 플레티넘4
 */
public class No1090 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] coordinate = new int[n][2];
        Set<Integer> listX = new TreeSet<>();
        Set<Integer> listY = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coordinate[i][0] = x;
            coordinate[i][1] = y;
            listX.add(x);
            listY.add(y);
        }

        System.out.println(checker(n, coordinate, listX, listY));
    }

    private static StringBuilder checker(int n, int[][] coordinate
            , Set<Integer> listX, Set<Integer> listY) {

        int[] result = new int[n];
        Arrays.fill(result, -1);

        for(int x : listX){
            for (int y : listY) {
                List<Integer> d = new ArrayList<>();
                for(int[] hs : coordinate){
                    int distance = Math.abs(x - hs[0]) + Math.abs(y - hs[1]);
                    d.add(distance);
                }

                d.sort(Comparator.naturalOrder());

                int temp = 0;
                for(int i=0;i<n;i++){
                    int distance = d.get(i);
                    temp += distance;
                    if(result[i] == -1) result[i] = temp;
                    else result[i] = Math.min(result[i], temp);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]);
            if(i < n-1){
                sb.append(" ");
            }
        }

        return sb;
    }
}
