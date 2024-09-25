package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 실버 3
 * 서로 다른 부분 문자열의 개수
 *
 */
public class No11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //자른 문자열의 중복을 방지하기 위해 Set선언
        Set<String> set = new HashSet<>();

        String S = br.readLine();
        //1부터 문자열의 길이만큼 자르는 경우들
        for(int i=1;i<=S.length();i++){
            //자르는 것은 처음부터 시작해서 i가 더해지는 만큼
            //그 때문에 j는 전체 길이에서 i를 뺀 것 까지 증가
            for(int j=0;j<=S.length()-i;j++){
                set.add(S.substring(j, j+i));
            }
        }

        System.out.println(set.size());
    }
}
