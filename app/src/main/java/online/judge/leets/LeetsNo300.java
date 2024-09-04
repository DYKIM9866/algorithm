package online.judge.leets;

public class LeetsNo300 {
    public static void main(String[] args) {
        LeetsNo300Solution sol = new LeetsNo300Solution();
        sol.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18});
        //{2,3,5,7,9,10,18,101}
    }
}

class LeetsNo300Solution {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp 배열은 LIS의 현재 길이를 저장
        int[] dp = new int[nums.length];
        int length = 0;  // 현재 LIS의 길이

        for (int num : nums) {
            // 이분 탐색을 사용하여 num이 dp 배열에서 적절한 위치를 찾기
            int left = 0, right = length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // left는 num이 들어가야 할 위치
            dp[left] = num;

            // length는 dp 배열의 현재 유효 길이
            if (left == length) {
                length++;
            }
        }
        return length;
    }

}

//class LeetsNo300Solution {
//    public static int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        int maxLength = 1;
//
//        for (int i = 0; i < n; i++) {
//            dp[i] = 1;
//        }
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//
//            maxLength = Math.max(maxLength, dp[i]);
//        }
//
//        return maxLength;
//    }
//}