https://leetcode.com/problems/decode-ways/description/

//91. Decode Ways
/*
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

-------------
Note: ch = '5'
  if we do ch-'0' -> it becomes 5
-------------
*/

//Recursion
    public int numDecodings(String s, int idx) {
        if (idx == s.length()) {
            return 1;
        }
        
        int count = 0;
        
        char ch1 = s.charAt(idx);
        
        if (ch1 == '0') {
            return 0;
        }
        
        count += numDecodings(s, idx + 1);  
        if (idx < s.length() - 1) {  //current index is not on the last index so we can form two digit decoding
            char ch2 = s.charAt(idx + 1);
            int num = (ch1 - '0') * 10 + (ch2 - '0');
            
            if (num <= 26) {
                count += numDecodings(s, idx + 2);
            }
        }
        
        return count;
    }

//memoization

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];
        return numDecodings(s, 0, dp);
    }
    public int numDecodings(String s, int idx, int[]dp){
        //base case 
        if(idx==s.length()){
            return dp[idx] = 1;
        }
        if(dp[idx]!=0){
            return dp[idx];
        }
        int count = 0;
        char ch1 = s.charAt(idx);              //curr idx 
        if(ch1=='0') return 0;

        count+= numDecodings(s, idx+1, dp);
        
        if(idx<s.length()-1){
            char ch2 = s.charAt(idx+1);        //next to curr idx
            int num =  (ch1-'0')*10+(ch2-'0');  //adding curr+next makes the new number
            if(num<=26){
                count+= numDecodings(s, idx+2,dp);
            }
        }
        dp[idx] = count;
        return dp[idx];
    }
}

//639. Decode Ways II
