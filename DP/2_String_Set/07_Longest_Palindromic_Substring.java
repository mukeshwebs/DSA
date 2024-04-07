https://leetcode.com/problems/longest-palindromic-substring/

TC: O(n)^2
SC: O(n)^2

class Solution {
    public String longestPalindrome(String s) {
        int si = 0; // Starting index of the longest palindrome substring
        int maxLen = Integer.MIN_VALUE; // Maximum length of the palindrome substring found
        int n = s.length(); // Di gayi string ki length
        boolean [][] dp = new boolean[n][n]; // 2D array jisme hum store karenge ki substring palindrome hai ya nahi

        // Sabhi possible substrings par loop chalao
        for(int gap = 0; gap < n; gap++) {
            for(int i = 0, j = gap; j < n; i++, j++) { // i, j ko aise update karo ki ye diagonal direction mein move karein
                // j hamesha gap se shuru hota hai aur i shuru ki row se shuru hota hai, taaki ye har diagonal par chale
                if(gap == 0) {
                    dp[i][j] = true; // Ek character hamesha palindrome hota hai
                } else if(gap == 1 && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true; // Do characters tab palindrome hote hain jab wo same hote hain
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1]; // Palindrome check karne ke liye diagonal value ko dekho
                }
                if(dp[i][j]) {
                    if(j - i + 1 > maxLen) { // Agar current substring ka length maxLen se bada hai, to maxLen aur starting index ko update karo
                        maxLen = j - i + 1;
                        si = i;
                    }
                }
            }
        }
        return s.substring(si, si + maxLen); // Sabse lambi palindrome substring ko return karo
    }
}
