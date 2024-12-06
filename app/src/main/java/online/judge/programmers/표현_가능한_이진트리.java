package online.judge.programmers;

public class 표현_가능한_이진트리 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(new long[]{7, 42, 5});
        int[] solution2 = solution.solution(new long[]{63, 111, 95});

        System.out.println();
    }
    static class Solution {
        int result;
        boolean[] binary;
        int treeLen;
        public int[] solution(long[] numbers) {
            int n = numbers.length;
            int[] answer = new int[n];

            for(int i=0;i<n;i++){
                String b= Long.toBinaryString(numbers[i]);

                int length = b.length();
                int exp = 1;
                do {
                    treeLen = (int) Math.pow(2, exp++) - 1;
                } while (treeLen < length);

                binary = new boolean[treeLen];
                int idx = treeLen - length;
                for(int j=0; j<length; j++) {
                    binary[idx++] = b.charAt(j) == '1';
                }

                result = 1;
                possible(0, treeLen-1, false); // s, e, 해당 루트가 더미인지
                answer[i] = result;

            }
            return answer;
        }

        private void possible(int s, int e, boolean check) {
            int mid = (s+e)/2;
            if(check && binary[mid]){
                result = 0;
                return;
            }

            if(s!=e){
                possible(s, mid - 1, !binary[mid]);
                possible(mid+1, e, !binary[mid]);
            }
        }
    }
}
