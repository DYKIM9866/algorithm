package online.judge.programmers;

import java.util.LinkedList;
import java.util.List;

/**
 * [1차]캐시
 *
 * 문제 해석
 *
 * 1. 캐시 크기와 도시이름 배열을 받는다.
 * 2. 캐시 히트 일 경우, 캐시 미스 일 경우 각각 처리 되는 시간은 1, 5
 * 3. 캐시 알고리즘은 LRU
 * 4. 도시이름 배열을 순서대로 처리 할 때 걸리는 총 실행시간을 구하라
 *
 * 문제 풀이
 *
 * 1. 큐는 중간 삭제가 안되므로 List 사용 List는 객체 삭제 삽입이 빈번하므로 LinkedList사용
 * 2. 캐시 사이즈가 0이라면 전부다 5씩 걸림
 * 3. 대소문자 구분하지 않으므로 LowerCase로 변경해줌
 * 4. List에서 객체의 index 찾은 후 존재 한다면 1추가해 주고 제거 후 재 삽입
 * 5. 없다면 5추가해 주고 캐시사이즈 꽉찼다면 앞에거 지워줌 그리고 넣어줌
 */
public class one차_캐시 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.solution(2,
                new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));

    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            List<String> que = new LinkedList<>();

            if(cacheSize == 0) return cities.length*5;

            for (String city : cities) {
                city = city.toLowerCase();
                int idx = que.indexOf(city);
                if(idx != -1){
                    answer += 1;
                    que.remove(idx);
                    que.add(city);
                }else{
                    answer+=5;
                    if(que.size() == cacheSize){
                        que.remove(0);
                    }
                    que.add(city);
                }

            }


            return answer;
        }
    }
}
