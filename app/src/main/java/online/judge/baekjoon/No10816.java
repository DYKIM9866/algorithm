package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No10816 {
    static int[] numberCards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        numberCards = new int[n];
        StringTokenizer numberToken = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numberCards[i] = Integer.parseInt(numberToken.nextToken());
        }
        Arrays.sort(numberCards);

        StringBuilder answer = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        StringTokenizer checkToken = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(checkToken.nextToken());
            answer.append(upperFirst(x) - sameFirst(x))
                    .append(" ");
        }

        System.out.println(answer.toString().trim());


    }

    private static int sameFirst(int x) {
        int lt = 0;
        int rt = numberCards.length;
        while(lt < rt){
            int center = (lt+rt)/2;
            if(numberCards[center] >= x){
                rt = center;
            }else{
                lt = center + 1;
            }
        }
        return lt;
    }

    private static int upperFirst(int x) {
        int lt = 0;
        int rt = numberCards.length;
        while(lt < rt){
            int center = (lt+rt)/2;
            if(numberCards[center] > x){
                rt = center;
            }else{
                lt = center + 1;
            }
        }
        return lt;
    }


}

