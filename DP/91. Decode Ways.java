https://leetcode.com/problems/decode-ways/description/

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];
        return numDecodings(s, 0, dp);
    }
    //helper method
    public int numDecodings(String s, int idx, int[]dp){
        //base case 
        if(idx==s.length()){
            return dp[idx] = 1;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int count = 0;
        char ch1 = s.charAt(idx);  //curr idx 
        if(ch1=='0') return 0;

        count+= numDecodings(s, idx+1, dp);
        
        if(idx<s.length()-1){
            char ch2 = s.charAt(idx+1);  //next to curr idx
            int num =  (ch1-'0')*10+(ch2-'0');  //adding curr+next makes the new number
            if(num<=26){
                count+= numDecodings(s, idx+2,dp);
            }
        }
        dp[idx] = count;
        return dp[idx];
    }
}
