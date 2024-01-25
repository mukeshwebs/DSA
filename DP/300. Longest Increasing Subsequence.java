https://leetcode.com/problems/longest-increasing-subsequence/description/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int maxLength = 0;
        int[] dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, LIS_memo(nums, i, dp));
        }
        return maxLength;
    }
    public static int LIS_memo(int[] nums, int ei, int[] dp) {
        if (dp[ei] != 0) { // memo
            return dp[ei];
        }
        int maxLen = 1;
        for (int i = ei - 1; i >= 0; i--) {
            if (nums[i] < nums[ei]) {
                int recLen = LIS_memo(nums, i, dp);
                maxLen = Math.max(maxLen, recLen + 1);
            }
        }
        dp[ei] = maxLen; // store in dp
        return maxLen;
    }
}
