package online.judge.baekjoon;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

/**
 * 체커 플레티넘4
 * 인프런 알고
 * 미완
 */
public class No1090 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        //좌표담기
        for(int i=0;i<n;i++){
            String[] strArr = reader.readLine().split(" ");
            list.add(List.of(Integer.valueOf(strArr[0]), Integer.valueOf(strArr[1])));
            xList.add(Integer.valueOf(strArr[0]));
            yList.add(Integer.valueOf(strArr[1]));
        }

        List<List<Integer>> distanceList = new ArrayList<>();
        //좌표당
        for(int i=0;i<list.size();i++){
            List<Integer> distance = new ArrayList<>();
            //
            for(int j=0;j<xList.size();j++){
                for(int k=0;k<yList.size();k++){
                    int x = Math.abs(list.get(i).get(0) - xList.get(j));
                    int y = Math.abs(list.get(i).get(1) - yList.get(k));
                }
            }
        }

    }
}
