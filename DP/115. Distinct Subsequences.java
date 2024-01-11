https://leetcode.com/problems/distinct-subsequences/description/
/*
Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit
Example 2:
*/

Time Complexity: O(n * m)
Space Complexity: O(n * m)

time complexity is O(n * m), where n is the length of string s and m is the length of string t
  
The space complexity is determined by the size of the memoization table. 
The memoization table dp has dimensions (n + 1) x (m + 1). Therefore, the space complexity is O(n * m) as well. 


//memoization
  
class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        // Initializing the dp array with -1
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return numDistinct_memo(s, t, n, m, dp);
    }

    public int numDistinct_memo(String s, String t, int n, int m, int[][] dp) {
        // base case
        if (m == 0) {
            dp[n][m] = 1; // empty string is always a subsequence
            return dp[n][m];
        }

        if (n == 0) {
            dp[n][m] = 0; // non-empty string can't be a subsequence of an empty string
            return dp[n][m];
        }

        // check memoization table
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // two recursive calls
        if (s.charAt(n - 1) == t.charAt(m - 1)) {
            int a = numDistinct_memo(s, t, n - 1, m - 1, dp);
            int b = numDistinct_memo(s, t, n - 1, m, dp);
            dp[n][m] = a + b;
        } else {
            // when characters are not equal, exclude the character from the first string
            dp[n][m] = numDistinct_memo(s, t, n - 1, m, dp);
        }
        return dp[n][m];
    }
}


//Tabulation
