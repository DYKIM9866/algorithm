package online.judge.programmers;


import java.io.IOException;
import java.util.*;

public class test {
    public static void main(String[] args) throws IOException {

        Map<int[], Integer> map = new HashMap<>();
        map.put(new int[]{1,2}, 1);
        map.put(new int[]{2,3}, 2);
        map.put(new int[]{3,4}, 3);


    }
}

class Solution {
    private int answer;
    private List<int[]> caseList;
    private int[] pick;
    public int solution(int[] picks, String[] minerals) {
        int dia = 0;
        int iron = 0;
        int stone = 0;

        answer = Integer.MAX_VALUE;
        caseList = new ArrayList<>();
        pick = picks;

        int picksLength = (picks[0] + picks[1] + picks[2]) * 5;

        int i=0;
        while(i < picksLength && i<minerals.length){
            if(minerals[i].equals("diamond")){
                dia += 1;
                iron += 5;
                stone += 25;
            }else if(minerals[i].equals("iron")){
                dia += 1;
                iron += 1;
                stone += 5;
            }else if(minerals[i].equals("stone")){
                dia += 1;
                iron += 1;
                stone += 1;
            }
            if(i%5 == 4){
                caseList.add(new int[]{dia, iron, stone});
                dia = 0;
                iron = 0;
                stone = 0;
            }

            i++;
        }

        if(dia != 0){
            caseList.add(new int[]{dia, iron, stone});
        }

        int[] visited = new int[caseList.size()];
        int[] visitedCase = new int[caseList.size()];

        dfs(visited, visitedCase, 0);

        return answer;
    }

    private void dfs(int[] visited, int[] visitedCase, int depth){
        if(depth == caseList.size()){
            int dia = 0;
            int iron = 0;
            int stone = 0;
            int cnt = 0;
            for(int i=0;i<depth;i++){
                if(visited[i] == 1) dia++;
                else if(visited[i] == 2) iron++;
                else if(visited[i] == 3) stone++;

                cnt += visitedCase[i];
            }

            if(dia > pick[0] || iron > pick[1] || stone > pick[2]) return;
            answer = Math.min(answer, cnt);

            return;
        }

        int[] tmp = caseList.get(depth);
        for(int i=0;i<3;i++) {
            visited[depth] = i + 1;
            visitedCase[depth] = tmp[i];
            dfs(visited, visitedCase, depth + 1);
        }
    }
}