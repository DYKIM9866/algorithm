package online.judge.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버4
 * 베스트셀러
 * 완료
 */
public class No1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> books = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String book = br.readLine();
            books.put(book, books.getOrDefault(book,0) + 1);
        }

        List<String> keys = new ArrayList<>(books.keySet());
        keys.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if(books.get(o1) == books.get(o2)){
                    return o1.compareTo(o2);
                }
                return books.get(o2) - books.get(o1);
            }
        });

        for(String key : keys){
            System.out.println(key);;
            break;
        }
    }
}
