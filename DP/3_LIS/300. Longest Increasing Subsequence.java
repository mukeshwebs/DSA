https://leetcode.com/problems/longest-increasing-subsequence/description/

//Memoization

Logic: LIS  - Longest increasing subsequence 
/*
Appraoch:

The LIS_memo function is a recursive function that calculates the length of the longest increasing subsequence ending at index ei.
It recursively calls itself for smaller indices, checking if the element at index ei can be added to the increasing subsequence starting from i.
*/

    TC:  O(n^2)
    SC: O(n)

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

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

    //Tabulation Approach
    
    TC:  O(n^2)
    SC: O(n)

/*
Appraoch:

It compares each element nums[i] with previous elements nums[j] (where j < i) to determine if nums[i] can be part of a longer increasing subsequence.
If nums[i] is greater than nums[j], it updates dp[i] to be the maximum between its current value and the length of the subsequence ending at j plus one.
*/

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


