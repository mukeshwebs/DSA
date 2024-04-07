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
--------------------------------------------------------------------------------------------------------------

// 516. Longest Palindromic Subsequence
public static int lpss(String s, int i, int j, int[][] dp) {
    if (i >= j)
        return dp[i][j] = (i == j ? 1 : 0);

    if (dp[i][j] != 0)
        return dp[i][j];

    if (s.charAt(i) == s.charAt(j))
        return dp[i][j] = lpss(s, i + 1, j - 1, dp) + 2;
    else
        return dp[i][j] = Math.max(lpss(s, i + 1, j, dp), lpss(s, i, j - 1, dp));
}

//with comments
class Solution {
     public static int lpss(String s, int i, int j, int[][] dp) {
        if (i >= j)  //case of i>j is for input-> "aa"
            return dp[i][j] = (i == j ? 1 : 0);

        if (dp[i][j] != 0) //memo
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

//using gap strategy

public static int lpss_DP(String s, int I, int J, int[][] dp) {
    int n = s.length();
    for (int gap = 0; gap < n; gap++) {
        for (int i = 0, j = gap; j < n; i++, j++) {
            if (i >= j) {
                dp[i][j] = (i == j ? 1 : 0);
                continue;
            }

            if (s.charAt(i) == s.charAt(j))
                //agr do char equal hai to unka len 2 aur uske palindrome hone ke liye
                //unke bich me jo characters hai unka palindrmic subsequence hme i+1, j-1 par milega
                //ex: abbcca if a and a are equals then unke bich me jo len hai uska
                dp[i][j] = dp[i + 1][j - 1] + 2;

            else
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
    }

    return dp[I][J];
}