package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 가운데를 말해요
 * 골드
 */
public class No1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            set.add(Integer.valueOf(br.readLine()));
            if(i % 2 == 0){

            }else{
            }
        }

        System.out.println(set);
    }
}
