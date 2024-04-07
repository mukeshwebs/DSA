https://www.geeksforgeeks.org/problems/friends-pairing-problem5425/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article

Note: we have to return the answr in mod so define the global mod variable
if friend is going alone then it will not form pair so  ->   countFriendsPairings(n - 1, dp);
if friend is pairing up with another remaining number from itself then it will pair up and it will pair up n-1 times ->countFriendsPairings(n - 2, dp) * (n - 1)

  
class Solution {
    static final int mod = 1000000007;

    public long countFriendsPairings(int n, long[] dp) {
        if (n == 0) {
            return dp[n] = 1;
        }

        if (dp[n] != -1)
            return dp[n];

        long single = countFriendsPairings(n - 1, dp);
        long pairUp = n - 2 >= 0 ? countFriendsPairings(n - 2, dp) * (n - 1) : 0;

        return dp[n] = (single + pairUp) % mod;
    }

    public long countFriendsPairings(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);

        return countFriendsPairings(n, dp);
    }
}
