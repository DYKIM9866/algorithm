package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 두라무리 휴지
 * 실버 5
 *
 */
public class No25178 {
    static final char[] mo = {'a','e','i','o','u'};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String first = br.readLine();
        String second = br.readLine();

        if(first.equals(second)) {
            System.out.println("YES");
            return;
        }

        System.out.println(duramuri(n,first, second));
    }

    private static String duramuri(int n,
                       String first, String second) {
        if(first.charAt(0) != second.charAt(0)
            || first.charAt(n-1) != second.charAt(n-1)) return "NO";

        StringBuilder firstB = new StringBuilder();
        StringBuilder secondB = new StringBuilder();
        int[] firstAlpha = new int[123];
        int[] secondAlpha = new int[123];

        for (int i = 0; i < n; i++) {
            boolean flagF = false;
            boolean flagS = false;
            for (int j = 0; j < 5; j++) {
                if(first.charAt(i) == mo[j]){
                    flagF = true;
                    break;
                }
            }
            for (int j = 0; j < 5; j++) {
                if(second.charAt(i) == mo[j]){
                    flagS = true;
                    break;
                }
            }

            if(!flagF){
                firstB.append(first.charAt(i));
            }
            if(!flagS){
                secondB.append(second.charAt(i));
            }

            firstAlpha[first.charAt(i)]++;
            secondAlpha[second.charAt(i)]++;
        }

        if(!firstB.toString().contentEquals(secondB)){
            return "NO";
        }

        for (int i = 0; i < n; i++) {
            if(firstAlpha[first.charAt(i)]
                != secondAlpha[first.charAt(i)]){
                return "NO";
            }
        }

        return "YES";
    }
}
