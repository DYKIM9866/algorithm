package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버 3
 * 파일 정리
 * 완료
 */
public class No20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //확장자의 값과 개수를 저장 할 Map을 선언
        Map<String, Integer> file = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();
            //.보다 밑으로 확장자의 이름을 추출
            String suffix = fileName.substring(fileName.indexOf('.') + 1);
            //map에 넣어줌
            file.put(suffix,file.getOrDefault(suffix,0)+1);
        }
        //정렬을 위해 keySet 추출
        List<String> keySet = new ArrayList<>(file.keySet());
        Collections.sort(keySet);

        //정렬된 keySet을 이용해 출력
        for(String key : keySet){
            System.out.println(key + " " + file.get(key));
        }
    }
}
