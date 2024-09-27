package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제 추천 시스템 Version1
 * 골드 4
 */
public class No21939 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        TreeMap<Integer, TreeSet<Integer>> diff = new TreeMap<>();
        Map<Integer, Integer> number = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            diff.putIfAbsent(l, new TreeSet<>());
            TreeSet<Integer> ps = diff.get(l);
            ps.add(p);

            number.put(p, l);
        }


        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] command = br.readLine().split(" ");
            switch (command[0]){
                case "add":
                    int p = Integer.parseInt(command[1]);
                    int l = Integer.parseInt(command[2]);

                    diff.putIfAbsent(l, new TreeSet<>());
                    TreeSet<Integer> ps = diff.get(l);
                    ps.add(p);

                    number.put(p, l);
                    break;
                case "recommend":
                    if(command[1].equals("1")){
                        int hardestLevel = diff.lastKey();
                        System.out.println(diff.get(hardestLevel).last());
                    }else{
                        int easiestLevel = diff.firstKey();
                        System.out.println(diff.get(easiestLevel).first());
                    }

                    break;
                case "solved":
                    int solvedProblem = Integer.parseInt(command[1]);
                    int level = number.get(solvedProblem);
                    TreeSet<Integer> pss = diff.get(level);
                    pss.remove(solvedProblem);
                    if (pss.isEmpty()) {
                        diff.remove(level);
                    }
                    number.remove(solvedProblem);
                    break;
            }
        }


    }

}
