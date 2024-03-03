https://www.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

TC: O(n)^2

Increasing subseqence me aane wale elements ka sum, jo ki maximum ho 
LOGIC: 


class Solution {
    public int maxSumIS(int nums[], int n) {
        int[] dp = new int[n];
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];                //previous in LIS -> dp[i] = 1 , now bcz dp[i] = nums[i] is only one elements is there that will be ans
            for (int j = 0; j < i; j++) {   //??
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);  //dp[j] + nums[i] , we are adding the nums[i] as it will be also part of answer
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}
