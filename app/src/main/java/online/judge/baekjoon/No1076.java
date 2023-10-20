package online.judge.baekjoon;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 저항
 * 완료 231020
 */
public class No1076 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,String> map = new HashMap<>();
        map.put("black","0");
        map.put("brown","1");
        map.put("red","2");
        map.put("orange","3");
        map.put("yellow","4");
        map.put("green","5");
        map.put("blue","6");
        map.put("violet","7");
        map.put("grey","8");
        map.put("white","9");

        String a = scan.nextLine();
        String b = scan.nextLine();
        String c = scan.nextLine();

        Long ab = Long.valueOf(map.get(a) + map.get(b));
        for(int i=0;i<Integer.parseInt(map.get(c));i++){
            ab*=10;
        }
        System.out.println(ab);


    }
}
