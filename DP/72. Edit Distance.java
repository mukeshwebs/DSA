https://leetcode.com/problems/edit-distance/description/

//with comments 
class Solution {
    public int minDistanceHelper(String word1, String word2, int n , int m, int[][]dp) {

            /*
    These cases cover 3 scenarios when 
    ex: s/t
    1. if s is empty so to convert t to s we will have to do the insert operation for the length of t
    2. if t is empty similar thing will be applicable 
    3. if both are empty then return 0
    */
    
        if (n == 0 || m == 0) {
            return dp[n][m] = (n == 0 ? m : n);
        }
        
       // Check if the value is already calculated
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        
        //Note: starting from the last of the both strings is considered more efficient
        /*
ex: saturday/sunday -----replace------> aturday/unday -> 3 possible calls (insert, delete, replace) 
                                                   insert: aturday/unday -> u aturday/unday -> (n, m-1)
                                                   delete: aturday/unday -> turday/unday -> (n-1, m)
                                                   replace: aturday/unday -> turday/unday -> (n-1, m-1)
        */
        
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
    
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int [][] dp = new int[n+1][m+1];

        for(int []d: dp){
            Arrays.fill(d, -1);
        }
        return minDistanceHelper(word1, word2, n, m, dp);
    }    
}



//without comments
---------------------------------------------------------------------------------------------------------
public class Solution {
    public int minDistanceHelper(String word1, String word2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return dp[n][m] = (n == 0 ? m : n);
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        int insert = minDistanceHelper(word1, word2, n, m - 1, dp);
        int delete = minDistanceHelper(word1, word2, n - 1, m, dp);
        int replace = minDistanceHelper(word1, word2, n - 1, m - 1, dp);

        if (word1.charAt(n - 1) == word2.charAt(m - 1)) {
            return dp[n][m] = replace;
        } else {
            return dp[n][m] = Math.min(Math.min(insert, delete), replace) + 1;
        }
    }
}

