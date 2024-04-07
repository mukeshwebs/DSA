https://www.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab


TC: O(n)^2
SC: O(n)^2
XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  
class Solution {
    public int longestPalinSubseq(String S) {
        int n = S.length();
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        return lpss(S, 0, n - 1, dp);
    }
    
    public int lpss(String s, int i, int j, int[][] dp) {
        if (i >= j)
            return dp[i][j] = (i == j ? 1 : 0);
        if (dp[i][j] != -1)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j))
            return dp[i][j] = lpss(s, i + 1, j - 1, dp) + 2;
        else
            return dp[i][j] = Math.max(lpss(s, i + 1, j, dp), lpss(s, i, j - 1, dp));
    }    
}

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
