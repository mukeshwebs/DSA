https://leetcode.com/problems/longest-palindromic-subsequence/description/

/*
Example 1:

Input: s = "bbbab"
Output: 4
Explanation: One possible longest palindromic subsequence is "bbbb".
Example 2:

Input: s = "cbbd"
Output: 2
Explanation: One possible longest palindromic subsequence is "bb".
*/  

TC: In the worst case, all possible pairs of indices (i, j) are considered, leading to a time complexity of O(n^2),
SC: The maximum depth of the recursion is limited by the length of the input string. Hence, the overall space complexity is O(n^2).
####################################################################################################
class Solution {
     public static int lpss(String s, int i, int j, int[][] dp) {
        if (i >= j)  //case of i>j is for input-> "aa"
            return dp[i][j] = (i == j ? 1 : 0);

        if (dp[i][j] != 0) //memp
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) //both chars are same
            return dp[i][j] = lpss(s, i + 1, j - 1, dp) + 2; //+2 because we have a len 2 subsequence
        else
          /* 
          ex: bbbab
            2 calls are possible in case when chars are not equal
            increase current i and keep j same and reduce j and keep i same
            Note: both calls are on same string on one pointer in the start and another in the end
          */ 
            return dp[i][j] = Math.max(lpss(s, i + 1, j, dp), lpss(s, i, j - 1, dp));  
    }

    public int longestPalindromeSubseq(String s) {
         int n = s.length();
        int[][] dp = new int[n][n];
        int ans = lpss(s, 0, n - 1, dp);

        return ans;       
    }
}
