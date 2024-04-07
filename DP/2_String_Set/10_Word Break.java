https://leetcode.com/problems/word-break/
/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.


Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
 */

TC:O(n * m)
SC:O(n + k)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(); // HashSet banayo jisme hum wordDict ke saare words daalenge
        int len = 0, n = s.length();
        for (String ss : wordDict) {
            set.add(ss); // HashSet mei word ko add karo
            len = Math.max(ss.length(), len);
        }

        boolean[] dp = new boolean[n + 1]; // boolean array banayo jisme hum store karenge ki substring wordDict mei hai ya nahi
        dp[0] = true; // dp ka 0th index true kiya, kyunki empty substring bhi wordDict mei hai
        for (int i = 0; i <= n; i++) { // Har index par loop chalao
            if (!dp[i]) // Agar dp[i] false hai, toh continue karo
                continue;

            for (int l = 1; l <= len && i + l <= n; l++) { // Har possible length ke liye loop chalao, starting from 1 to len and i+l should not exceed n
                String substr = s.substring(i, i + l); // substring nikalo from i to i+l
                if (set.contains(substr)) { // Agar substring HashSet mei hai, toh
                    dp[i + l] = true; // dp[i+l] ko true kar do
                }
            }
        }
        return dp[n]; // dp[n] ki value ko return karo, which represents whether the entire string can be segmented or not
    }
}

