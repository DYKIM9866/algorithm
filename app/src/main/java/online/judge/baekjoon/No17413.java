package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 실버 3
 * 단어 뒤집기 2
 * 완료
 */
public class No17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        //정답용 sb
        StringBuilder answer = new StringBuilder();
        //뒤집기용 sb
        StringBuilder reverse = new StringBuilder();


        for(int i=0;i<S.length();i++){

            if (S.charAt(i) == '<') {
                //reverse가 비어져 있지 않다면 answer에 추가 해주고 비우기
                if (reverse.length() != 0) {
                    answer.append(reverse.reverse());
                    reverse.setLength(0);
                }
                //괄호 만났을 때 닫는 괄호 만날 때 까지 돌리기
                for (int j = i; j < S.length(); j++) {
                    answer.append(S.charAt(j));
                    if (S.charAt(j) == '>') {
                        i = j;
                        break;
                    }
                }
            } else {
                //공백 만나면 돌리고 넣어주고 비우기
                if (S.charAt(i) == ' ') {
                    answer.append(reverse.reverse())
                            .append(' ');
                    reverse.setLength(0);
                    continue;
                }
                reverse.append(S.charAt(i));
            }
        }
        //마지막 종료 됐을 경우 reverse가 남아있을 경우를 대비하여 돌리고 넣어주기
        answer.append(reverse.reverse());

        System.out.println(answer);
    }
}
