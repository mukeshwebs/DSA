https://leetcode.com/problems/coin-change/description/

//memoization

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1); // Initialize memoization array with -1
        int ans = coinCount(coins, amount, dp);
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    int coinCount(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        else if (amount < 0) return Integer.MAX_VALUE;

        if (dp[amount] != -1) return dp[amount]; // If the value is already computed, return it

        int minCoins = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) { // Iterate through all coins
            int subproblem = coinCount(coins, amount - coins[i], dp);
            if (subproblem != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + subproblem);
            }
        }
        dp[amount] = minCoins; // Store the result in the memoization array
        return minCoins;
    }
}

//tabulation

class Solution {
    public int coinChange(int[] arr, int Tar) {
        int[] dp = new int[Tar + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int tar = 1; tar <= Tar; tar++) {
            for (int ele : arr) {
                if - ele >= 0)(tar 
                    dp[tar] = Math.min(dp[tar - ele] + 1, dp[tar]);
            }
        }
        //if dp is unchanged for the target val means target value cannot be acheived 
        //so return -1, if it's value is changed then return (int) 1e9
        return dp[Tar] != (int) 1e9 ? dp[Tar] : -1;
    }
}
/*
ways:
memo, tabu
+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
| Amount |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 10  | 11  |
+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|   1    |  0  |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |  9  | 10  | 11  |
+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|   2    |  0  |  1  |  1  |  2  |  2  |  3  |  3  |  4  |  4  |  5  |  5  |  6  |
+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
|   5    |  0  |  1  |  1  |  2  |  2  |  1  |  2  |  2  |  3  |  3  |  2  |  3  |
+--------+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+
*/
