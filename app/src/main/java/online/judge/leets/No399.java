package online.judge.leets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Evaluate Division
 */
public class No399 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        List<List<String>> equations = new ArrayList<>(){{
            add(new ArrayList<>(){{
                add("a");
                add("b");
            }});
            add(new ArrayList<>(){{
                add("b");
                add("c");
            }});
        }};
        List<List<String>> queries = new ArrayList<>(){{
            add(new ArrayList<>(){{
                add("a");
                add("c");
            }});
            add(new ArrayList<>(){{
                add("b");
                add("a");
            }});
            add(new ArrayList<>(){{
                add("a");
                add("e");
            }});
            add(new ArrayList<>(){{
                add("a");
                add("a");
            }});
            add(new ArrayList<>(){{
                add("x");
                add("x");
            }});
        }};

        double[] values = new double[2];
        values[0] = 2.0;
        values[1] = 3.0;
        solution.calcEquation(equations, values, queries);
    }
}

class Solution2 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer = new double[queries.size()];
        Map<String, Map<String, Double>> dic = new HashMap<>();

        for(int i=0;i<values.length;i++){
            String first = equations.get(i).get(0); //Ai
            String second = equations.get(i).get(1); //Bi

            double value = values[i];

            Map<String, Double> firstMap = dic.getOrDefault(first,new HashMap<>());
            firstMap.put(second, value);
            dic.put(first, firstMap);

            Map<String, Double> secondMap = dic.getOrDefault(second,new HashMap<>());
            secondMap.put(first,value * (-1));
            dic.put(second, secondMap);
        }

        for (int j = 0; j < queries.size(); j++) {
            String first = queries.get(j).get(0); //Cj
            String second = queries.get(j).get(1); //Dj

            if(first.equals(second)) answer[j] = 1.0;
            else if(dic.get(first) == null) answer[j] = -1.0;
            else{
                answer[j] = 200;
            }
        }
        return answer;
    }
}
