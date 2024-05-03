package online.taewon.section4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 아나그램 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();

        System.out.println(mySol(str1, str2));
        System.out.println(classSol(str1,str2));
    }

    private static String mySol(String str1, String str2) {
        String result = "YES";
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(char chr : str1.toCharArray()){
            map1.put(chr, map1.getOrDefault(chr,0)+1);
        }
        for(char chr : str2.toCharArray()){
            map2.put(chr, map2.getOrDefault(chr,0)+1);
        }
        for(char chr : map1.keySet()){
            if(map1.get(chr) != map2.getOrDefault(chr,0)){
                return "NO";
            }
        }
        return result;
    }
    private static String classSol(String str1, String str2){
        String result = "YES";
        Map<Character, Integer> map = new HashMap<>();
        for(char chr : str1.toCharArray()){
            map.put(chr,map.getOrDefault(chr,0)+1);
        }
        for(char chr : str2.toCharArray()){
            if(map.containsKey(chr)){
                if(map.get(chr) <= 0) {
                    return "NO";
                }else{
                    map.put(chr,map.getOrDefault(chr,0)-1);
                }
            }else{
                return "NO";
            }
        }

        return result;
    }
}
