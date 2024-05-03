package online.taewon.section4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 학급_회장 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String select  = scan.next();
        System.out.println(mySol(n, select));
    }

    private static char mySol(int n, String select) {
        char result = '0';
        Map<Character, Integer> map = new HashMap<>();
        for(char chr : select.toCharArray()){
            if(map.containsKey(chr)) map.put(chr,map.get(chr)+1);
            else map.put(chr,1);
        }

        int max = 0;
        for(char chr : map.keySet()){
            if(max < map.get(chr)){
                max = map.get(chr);
                result = chr;
            }
        }
        return result;
    }
}
