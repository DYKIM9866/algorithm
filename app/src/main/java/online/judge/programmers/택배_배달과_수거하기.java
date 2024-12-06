package online.judge.programmers;

public class 택배_배달과_수거하기 {
    public static void main(String[] args) {

    }

    static class Solution1 {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;
            int d = 0;
            int p = 0;
            //반대에서 출발
            for(int i=n-1;i>=0;i--){
                //배달해야 하는 거리 빼줌
                d -= deliveries[i];
                //픽업해야 하는 거리 빼줌
                p -= pickups[i];

                // 0과 같아지거나 커질 때까지 돌려줌
                while(d < 0 || p < 0){
                    d += cap;
                    p += cap;
                    answer += (i+1)*2;
                }
            }
            return answer;
        }
    }
}
