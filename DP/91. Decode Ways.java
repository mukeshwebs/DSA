https://leetcode.com/problems/decode-ways/description/
/*
Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

*/

//Memoization

TC: O(2^n)  -  exponential Time complexity because for each idx 2 recursive calls are made(2 decision for each index)
SC: O(n)


class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];  //n+1 to accommodate indices from 0 to n. Therefore, the space used by the dp array is O(n).
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

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//Tabulation
    
class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int [] dp = new int[n+1];
        return numDecodings(s, 0, dp);
    }
    public int numDecodings(String s, int IDX, int[]dp){
        //base case 
        for(int idx = s.length(); idx>=0; idx--){
            if(idx==s.length()){
               dp[idx] = 1;
                continue;
            }
        
        // if(dp[idx]!=0){
        //     return dp[idx];
        // }
        int count = 0;
        char ch1 = s.charAt(idx);  //curr idx 
        if(ch1=='0') {
            dp[idx] = 0;
            continue;
        }

        // count+= numDecodings(s, idx+1, dp);  //rec
         count+= dp[idx+1];
        
        if(idx<s.length()-1){ //idx<s.length()-1 means it is not at the last index
            char ch2 = s.charAt(idx+1);  //next to curr idx
            int num =  (ch1-'0')*10+(ch2-'0');  //adding curr+next makes the new number
            if(num<=26){
                // count+= numDecodings(s, idx+2,dp);
                count+= dp[idx+2];
            }
        }
        dp[idx] = count;
        }
        return dp[IDX];
    }
}
