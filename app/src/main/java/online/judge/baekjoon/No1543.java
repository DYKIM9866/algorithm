package online.judge.baekjoon;

import java.util.Scanner;

/**
 * 문서 검색
 * 실버 5
 */
public class No1543 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        StringBuilder doc = new StringBuilder(scan.nextLine());
        String word = scan.nextLine();

        int cnt = 0;
        while(doc.length() >= word.length()){

            int idx = doc.indexOf(word);

            if(idx == -1) break;

            doc.delete(0, idx + word.length());
            cnt++;
        }
        System.out.println(cnt);
    }
}
