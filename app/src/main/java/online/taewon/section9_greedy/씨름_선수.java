package online.taewon.section9_greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 씨름_선수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Body> arr = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr.add(new Body(Integer.parseInt(st.nextToken())
                    , Integer.parseInt(st.nextToken())));
        }

        System.out.println(sol(arr, n));
    }

    private static int sol(List<Body> arr, int n) {
        int result = 0;
        Collections.sort(arr);
        int max = Integer.MIN_VALUE;
        for (Body body : arr) {
            if(body.weight > max){
                max = body.weight;
                result++;
            }
        }

        return result;
    }

    static class Body implements Comparable<Body>{
        int height;
        int weight;

        public Body(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Body o) {
            return o.height - this.height;
        }
    }
}
