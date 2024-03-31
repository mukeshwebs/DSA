https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    public String longestPalindrome(String s) {
        int si = 0;
        int maxLen = Integer.MIN_VALUE;
        int n = s.length();
        boolean [][] dp = new boolean[n][n];
        for(int gap=0; gap<n; gap++){
            for(int i=0, j=gap; j<n; i++, j++){  // i, j are updated in a way so that it moves in digonal direction
              //j is always starting with gap and i begins from starting row, so that it traverses in each digonal f 
            if(gap==0){
                dp[i][j] = true;
            }else if(gap==1 &&  s.charAt(i)==s.charAt(j)){
                 dp[i][j] = true;
            }else{
                dp[i][j] = s.charAt(i)==s.charAt(j) && dp[i+1][j-1];   //checking diagonal val
            }
            if(dp[i][j]){
                if(j-i+1>maxLen){
                    maxLen = j-i+1;
                    si = i;
                }
            }            
          }
        }
        return s.substring(si, si+maxLen);
    }
}
