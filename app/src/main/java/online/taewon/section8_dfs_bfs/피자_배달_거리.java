package online.taewon.section8_dfs_bfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 피자_배달_거리 {
    static int n,m, result = Integer.MAX_VALUE;
    static List<Point> pz,hs;
    static int[] combi;
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            n = scan.nextInt();
            m = scan.nextInt();
            pz = new ArrayList<>();
            hs = new ArrayList<>();
            combi = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int temp = scan.nextInt();
                    if(temp == 1) hs.add(new Point(i, j));
                    if(temp == 2) pz.add(new Point(i, j));
                }
            }

            combination(0, 0);
            System.out.println(result);
        }
    }

    private static void combination(int depth, int start) {
        if (depth == m) {
            int sum = 0;
            for (Point house : hs) {
                int minimum = Integer.MAX_VALUE;
                for (Point pizza : pz)
                    minimum = Math.min(Math.abs(house.x - pizza.x)
                            + Math.abs(house.y - pizza.y), minimum);
                sum += minimum;

            }
            result = Math.min(sum, result);
        }else{
            for (int i = start; i < pz.size(); i++) {
                combi[depth] = i;
                combination(depth + 1, i+1);
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

