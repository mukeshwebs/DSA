https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n= nums.length;
       int [] dp = new int[n];
       int [] count = new int[n];
       int maxCount = 0;
       int maxLength = 0;
       int ei = nums.length;

       for(int i=0; i<n; i++){
           dp[i] = 1; //Set the LIS to be 1 for each iterating i, it will be updated in inner loop accordingly
           count[i] = 1;
           for(int j=ei-1; j>=0; j--){
               if(nums[i]>nums[j]){
                   if(dp[j]+1>dp[i]){ 
                       dp[i] = dp[j]+1;
                       count[i] = count[j];
                   }else if(dp[i]==dp[j]+1){
                       count[i]+= count[j];
                   }
               }
           }
           //update maxCount and maxLength
           if(dp[i]>maxLength){
               maxLength = dp[i];
               maxCount = count[i];
           }else if(dp[i]==maxLength){ //to add up the previous
               maxCount+= count[i];
           }
       } 
      return maxCount;         
    }
}
