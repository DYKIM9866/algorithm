package online.taewon.section7;

import java.util.ArrayList;
import java.util.Scanner;

public class 경로탐색_인접리스트 {

    static int n, answer;
    static int[] check;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        int m = scan.nextInt();
        graph = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        check = new int[n + 1];

        for(int i = 0; i < m; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
        }
        check[1] = 1 ;
        arrayListSol(1);
        System.out.println(answer);
    }

    private static void arrayListSol(int v) {
        if(v == n) answer ++;
        else{
            for (int nv : graph.get(v)) {
                if(check[nv] == 0){
                    check[nv] = 1;
                    arrayListSol(nv);
                    check[nv] = 0;
                }
            }
        }
    }


}
