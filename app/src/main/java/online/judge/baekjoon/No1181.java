package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 단어정렬
 * 실버 5
 * 문제 해석
 * 1. 단어가 들어오면 정렬한다.
 * 2. 그 기준은 짧은 것이 우선
 * 3. 같다면 사전 순으로
 *
 * 풀이
 * 1. 중복을 제거하기 위해 Set자료구조에 담아준다.
 * 2. List에 옮겨 담아주고 기준에 맞게 정렬을 한다.
 * 3. 값을 출력한다.
 */
public class No1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        List<String> wordList = new ArrayList<>(set);

        wordList.sort((s1,s2)-> {
            if(s1.length() == s2.length()){
                return s1.compareTo(s2);
            }else{
                return s1.length() - s2.length();
            }
        });


        StringBuilder sb = new StringBuilder();
        for(String word : wordList){
            sb.append(word).append("\n");
        }

        System.out.println(sb);
    }
}
