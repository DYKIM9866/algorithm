package online.taewon.section4_hashmap_treeset;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 모든_아나그램_찾기 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String k = scan.nextLine();
        System.out.println(mySol(s,k));
    }

    private static int mySol(String s, String k) {
        int result = 0;
        Map<Character,Integer> kMap = new HashMap<>();
        Map<Character,Integer> sMap = new HashMap<>();
        char[] sArr = s.toCharArray();
        char[] kArr = k.toCharArray();

        for(int i=0;i<k.length()-1;i++){
            sMap.put(sArr[i],sMap.getOrDefault(sArr[i],0) + 1);
            kMap.put(kArr[i],kMap.getOrDefault(kArr[i],0) + 1);
        }
        kMap.put(kArr[k.length()-1],kMap.getOrDefault(kArr[k.length()-1],0) + 1);

        int lt = 0;
        for(int rt=k.length()-1;rt<s.length();rt++){
            sMap.put(sArr[rt],sMap.getOrDefault(sArr[rt],0) + 1);
            if(sMap.size() == kMap.size()){
                boolean bool = true;
                for(char tmp : kMap.keySet()){
                    if(sMap.getOrDefault(tmp,0) != kMap.get(tmp)){
                        bool = false;
                        break;
                    }
                }
                if(bool) result++;
            }

            sMap.put(sArr[lt],sMap.get(sArr[lt]) - 1);
            if(sMap.get(sArr[lt]) == 0) sMap.remove(sArr[lt]);
            lt++;
        }

        return result;
    }
}
