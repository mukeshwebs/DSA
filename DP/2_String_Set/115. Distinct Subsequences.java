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
        int [][]dp = new int[n+1][m+1];
        for(int []d: dp){
            Arrays.fill(d, -1);
        }
        return numDistinct_dp(s, t, n, m, dp);
    }

    public int numDistinct_dp(String s, String t, int n, int m, int[][]dp){
        //base case 
        if(m==0){
            return dp[n][m] = 1;
        }
        if(n<m) return dp[n][m] = 0;

        //memo
        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        //if both the character matches then their can 2 possibiities 
        /*
        rabbbit/rabbit - > abbbit/abbit : find rem 'abbit' in the string s
        another possiblity is to find the t in the string s from the next index 
        bcz we can find the complete t in s after both has same chars

        rabbbit/rabbit ->  abbbit/rabbit

        */
        if(s.charAt(n-1)==t.charAt(m-1)){
            int a = numDistinct_dp(s, t,n-1, m-1, dp);
            int b = numDistinct_dp(s, t,n-1, m, dp);
            return dp[n][m] = a+b;
        }else{
            int b = numDistinct_dp(s, t,n-1, m, dp);
            return dp[n][m] = b;
      }
    }
}
