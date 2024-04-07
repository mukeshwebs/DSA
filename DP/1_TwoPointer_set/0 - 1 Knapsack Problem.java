https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
/*
Input:
N = 3
W = 4
values[] = {1,2,3}
weight[] = {4,5,1}
Output: 3
Explanation: Choose the last item that weighs 1 unit and holds a value of 3. 
*/

TC: 
SC:

Logic:
1. W is the bag capacity, weight array se max W capacity tk ke elements rakh skte hai 
2. we have to take the min wt which has the max values to maximise the total value


N = 3 - Size
W = 4 - Capacity
values[] = {1,2,3}
weight[] = {4,5,1}

Note:
Start from n-1 
so in the given example if we start from last index w is 1 
class Solution {
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1]; // DP table for memoization
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }
        return knapSackHelper(W, wt, val, n, dp);
    }

    public static int knapSackHelper(int W, int wt[], int val[], int n, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0;
        }
        // Memoization
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        
        int maxAns = 0;
        if (W - wt[n - 1] >= 0) {
          //NOTE: Addding the values which we pick 
            maxAns = Math.max(maxAns, knapSackHelper(W - wt[n - 1], wt, val, n - 1, dp) + val[n - 1]); // Pick
        }
        maxAns = Math.max(maxAns, knapSackHelper(W, wt, val, n - 1, dp)); // Do not pick
        return dp[n][W] = maxAns;
    }
}
