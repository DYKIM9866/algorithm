package online.judge.leets;

import java.util.*;

/**
 * Group Anagrams
 */
public class LeetNo49 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.groupAnagrams(new String[]{
                "eat","tea","tan","ate","nat","bat"
        });
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for(String str : strs){
                int[] alpha = new int[26];
                for(char chr : str.toCharArray()){
                    alpha[chr-'a']++;
                }
                String key = Arrays.toString(alpha);
                List<String> obj = map.getOrDefault(key, new ArrayList<>());
                obj.add(str);
                map.put(key, obj);
            }

            List<List<String>> answer = new ArrayList<>();
            for(String key : map.keySet()){
                answer.add(map.get(key));
            }

            return answer;
        }
    }
}
