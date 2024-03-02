https://leetcode.com/problems/longest-increasing-subsequence/description/

//Memoization

Logic: LIS  - Longest increasing subsequence 
    The approach used is straight forward, [10,9,2,5,3,7,101,18]
    for every index waha tk ke increase subseuqneces find kr rhe hai 
    ex: from the lengthOfLIS we are passing i 
    intialliy i = 101
    so in LIS_memo it will check the inceasing subseuneces till 101 so similarly 
    we are finding the lis at each index and maitaining the maximum.

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
        if (dp[ei] != 0) { // memoization
            return dp[ei];
        } 
        int maxLen = 1;                              //maxLen is 1 bcz an element itself can be increase subsequence
        for (int i = ei - 1; i >= 0; i--) {            //starting from that element and for increasing subq checking smaller in previous of that 
            if (nums[i] < nums[ei]) {
                int recLen = LIS_memo(nums, i, dp);
                maxLen = Math.max(maxLen, recLen + 1);
            }
        }
        dp[ei] = maxLen; // store in dp
        return maxLen;
    }
}

//Tabulation

//tabulation
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int []dp = new int[n+1];
        return lengthOfLIS_LR(nums, dp);
    }
    
    public static int lengthOfLIS_LR(int [] nums, int []dp){
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;
            for(int j=i-1; j>=0; j--){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLen = Math.max(dp[i],maxLen);
        }
        return maxLen;
    }
}


