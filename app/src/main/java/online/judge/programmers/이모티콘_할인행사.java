package online.judge.programmers;

/**
 * 문제 해석
 * 1. 이모티콘 플러스를 가입하도록 만들고 싶습니다.
 * 2. 유저 배열이 주어지는데 각 유저들은 [원하는 할인율, 예산]을 가지고 있습니다.
 * 3. 유저들은 원하는 할인율보다 같거나 높을 경우만 구매합니다.
 * 4. 이모티콘들의 할인율은 10,20,30,40 만 있다고 가정합니다.
 * 5. 만약 유저들이 할인율대로 구매했을 때 본인의 예산을 넘어가게 되면 이모티콘 플러스를 가입합니다.
 * 6. 유저들의 이모티콘 플러스가입을 유도하기 위해 이모티콘들의 할인율을 지정하면 됩니다.
 * 7. 이모티콘 플러스가 가장 우선되고 그다음으로 이모티콘 구매가격이 우선됩니다
 * 8. 그러니까 이모티콘 가입 수 내림차순 이모티콘 구매가격 내림차순 했을 경우 가장 위의 값
 *
 * 문제 풀이
 * 1. 완전탐색을 통해 해결했다.
 * 2. 우선 할인율을 선택해야 했다. dfs를 이용해 할인율을 선택한다.
 * 3. 만약 선택이 완료되었을 때는 선택된 할인율을 가격에 반영하고 각 유저들이 그 이모티콘을 구매하는지 확인한다.
 * 4. 위의 과정만 구현하면 완료된다.
 * 5. 코드를 보면 이해가능하다.
 */

public class 이모티콘_할인행사 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(
                new int[][]{{40,10000},{25,10000}},
                new int[]{7000,9000}
        );
        solution = new Solution();
        solution.solution(
                new int[][]{{40,2900},{23,10000},
                        {11,5200}, {5,5900}, {40,3100},
                        {27,9200},{32,6900}},
                new int[]{1300,1500,1600,4900}
        );
    }

    static class Solution {
        int emoLen;
        int[] emoDis;
        int[] emoticons2;
        int[][] users2;
        int[] discount = {10, 20, 30, 40};
        int[] answer = new int[2];
        public int[] solution(int[][] users, int[] emoticons) {

            emoticons2 = emoticons;
            users2 = users;
            //이모티콘 개수
            emoLen = emoticons.length;
            //선택한 할인률
            emoDis = new int[emoLen];

            selectDiscount(0, 0);
            return answer;
        }

        private void selectDiscount(int choice, int start){
            if(choice == emoLen){
                int[] price = new int[emoLen];
                //할인 가격 저장
                for (int i = 0; i < emoLen; i++) {
                    price[i] = emoticons2[i] * (100 - emoDis[i]) / 100;
                }

                int emoticonPlus = 0;
                int purchase = 0;

                //유저 비교
                for (int i = 0; i < users2.length; i++) {
                    int dis = users2[i][0];
                    int budget = users2[i][1];
                    int purchase2 = 0;
                    for (int j = 0; j < emoLen; j++) {
                        if(emoDis[j] >= dis){
                            budget -= price[j];
                            purchase2 += price[j];
                        }
                        if(budget <= 0){
                            emoticonPlus++;
                            purchase2 = 0;
                            break;
                        }
                    }
                    purchase += purchase2;
                }

                if(answer[0] < emoticonPlus){
                    answer[0] = emoticonPlus;
                    answer[1] = purchase;
                }else if(answer[0] == emoticonPlus){
                    answer[1] = Math.max(answer[1], purchase);
                }

                return;
            }

            for(int i=start;i<emoLen;i++){
                for(int j=0;j<4;j++){
                    emoDis[choice] = discount[j];
                    selectDiscount(choice+1, i+1);
                }
            }
        }
    }
}
