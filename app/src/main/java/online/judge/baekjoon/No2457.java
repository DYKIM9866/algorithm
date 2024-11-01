package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 공주님의 정원
 * 골드 3
 *
 *문제 해석
 * 1. 공주를 위해 공주가 원하는 기간에 어떤 꽃이든 피어있는 정원을 만들고 싶다.
 * 2. 3월 1일부터 11월 30일가지는 매일 꽃이 피어있도록 한다.
 * 3. 조건에 맞는 최소의 꽃의 개수를 출력하면된다.
 * 4. 첫째 줄에 꽃의 개수 N, 다음 줄 부터 각 꽃의 피는 날짜와 지는 날짜가 주어진다.
 * 5. 꽃의 개수가 최소가 되는 경우를 출력하라
 *
 * 문제풀이
 * 1. 문제를 읽으면 그때그때 최적의 해를 찾아 해를 찾는 그리디 알고리즘을 떠올릴 수 있다.
 * 2. 개화시기, 낙화시기를 오름차순, 내림차순으로 정렬해서 결정한다.
 * 3. 시기가 적합한 꽃들을 찾아간다.
 * 4. 꽃 찾지 못하면 0을 출력한다.
 */
public class No2457 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Flower> flowers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startM = Integer.parseInt(st.nextToken());
            int startD = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endD = Integer.parseInt(st.nextToken());

            int startDate = startM * 100 + startD;
            int endDate = endM * 100 + endD;
            if(endDate < 301) continue;
            flowers.add(new Flower(startDate, endDate));
        }

        Collections.sort(flowers);

        //시작 날짜
        int start = 301;
        //현재스케쥴 끝나는 시기
        int scheduleEnd = 301;
        int answer = 0;
        int idx = 0;

        while(start < 1201){
            boolean flag = false;

            //다음 값 찾기
            for (int i = idx; i < n; i++) {
                Flower flower = flowers.get(i);

                //시작하는 날짜가 현재 찾는게 아니라면 나감
                if(flower.start > start){
                    break;
                }
                //현재 찾는 값중 끝나는게 가장 큰 것을 찾음
                if(scheduleEnd < flower.end){
                    scheduleEnd = flower.end;
                    flag = true;
                    idx = i+1;
                }
            }

            if(flag){
                start = scheduleEnd;
                answer++;
            }else{
                System.out.println(0);
                return;
            }
        }

        System.out.println(answer);
    }

    static class Flower implements Comparable<Flower>{
        int start;
        int end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower o) {
            return Comparator.comparingInt((Flower flower) -> flower.start)
                    .thenComparingInt(flower -> -flower.end)
                    .compare(this, o);
        }
    }
}
