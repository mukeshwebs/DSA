https://leetcode.com/problems/delete-operation-for-two-strings/description/

TC: 
SC: 

class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][]dp = new int[n+1][m+1];
        for(int []d: dp){
            Arrays.fill(d, -1);
        }
        return minDistanceHelper(word1, word2, n,m,dp);
    }
    public int minDistanceHelper(String word1, String word2, int n, int m, int [][]dp) {
        //base case 
        if(n==0 || m==0){
            return dp[n][m] = n==0?m:n;
        }
        //memo
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        //rec
        if(word1.charAt(n-1)==word2.charAt(m-1)){
           return dp[n][m] =  minDistanceHelper(word1, word2, n-1, m-1, dp); //replace
        }else{

          NOTE: do no place replace call in else statement 
            
            //2 calls delete from word1 and delete from word 2
            int deleteFromOne = minDistanceHelper(word1, word2, n-1, m, dp);
            int deleteFromTwo = minDistanceHelper(word1, word2, n, m-1, dp);
            int res = Math.min(deleteFromOne,deleteFromTwo)+1;
            return dp[n][m] = res;
        }
    }    
}
