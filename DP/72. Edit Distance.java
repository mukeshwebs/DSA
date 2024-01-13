https://leetcode.com/problems/edit-distance/description/

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][] dp = new int[n+1][m+1];

        for(int []d: dp){
            Arrays.fill(d, -1);
        }
        return minDistanceHelper(word1, word2, n, m, dp);
    }
    
    public int minDistanceHelper(String word1, String word2, int n , int m, int[][]dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = (n == 0 ? m : n);
        }
       // Check if the value is already calculated
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        int insert  = minDistanceHelper(word1, word2, n, m-1, dp);
        int delete = minDistanceHelper(word1, word2, n-1, m, dp);
        int replace = minDistanceHelper(word1, word2, n-1, m-1, dp);
        
        //when both the chars are same 
        if(word1.charAt(n-1)==word2.charAt(m-1)){
            return dp[n][m] = replace;
        }else{ //if not equal then take 3 decision 
            return dp[n][m] = Math.min(Math.min(insert, delete), replace)+1;
            // return dp[n][m] = Math.min(Math.min(insert, delete), replace);
        }  
    }    
}
