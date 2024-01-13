https://leetcode.com/problems/longest-common-subsequence/description/

/*
Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
*/

TC: O(n * m)
SC: O(n * m)
----------------------------------------------------------------------------------------------------------------------------------
import java.util.Arrays;

class Solution {
    public int longestCommonSubsequenceHelper(String text1, String text2, int n, int m, int[][] dp) {
        // base case
        if (n == 0 || m == 0) {
            return 0;
        }

        // memoization
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (text1.charAt(n - 1) == text2.charAt(m - 1)) {
            return dp[n][m] = 1 + longestCommonSubsequenceHelper(text1, text2, n - 1, m - 1, dp); // include current character
        } else {
            return dp[n][m] = Math.max(longestCommonSubsequenceHelper(text1, text2, n - 1, m, dp),
                    longestCommonSubsequenceHelper(text1, text2, n, m - 1, dp));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return longestCommonSubsequenceHelper(text1, text2, n, m, dp);
    }
}
