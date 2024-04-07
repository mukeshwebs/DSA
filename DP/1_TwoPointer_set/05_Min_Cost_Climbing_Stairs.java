https://leetcode.com/problems/min-cost-climbing-stairs/

/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.


Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
 */

 // TC: O(n), SC: O(n)

class Solution {
    public static int minCostClimbingStairs(int n, int[] cost, int[] dp) {
        //base case
        // Agar 'n' current cost ke length se jyada ho gaya hai, toh koi cost nahi lagani hai
        if (n >= cost.length) {
            return 0;
        }
        // Agar 'n' pehle se calculate kar chuke hain, toh seedha answer return karo
        if (dp[n] != -1) {
            return dp[n];
        }
        int a = minCostClimbingStairs(n + 1, cost, dp) + cost[n];
        int b = minCostClimbingStairs(n + 2, cost, dp) + cost[n];
        dp[n] = Math.min(a, b);
        return dp[n];
    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // Calculation shuru karo, pehla step index 0 se
        int ans1 = minCostClimbingStairs(0, cost, dp);
        // Calculation shuru karo, pehla step index 1 se
        int ans2 = minCostClimbingStairs(1, cost, dp);
        return Math.min(ans1, ans2);
    }
}

