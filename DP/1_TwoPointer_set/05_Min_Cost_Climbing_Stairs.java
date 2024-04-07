https://leetcode.com/problems/min-cost-climbing-stairs/


class Solution {
    public static int minCostClimbingStairs(int n, int[] cost, int []dp) {
        //base case 
        if(n>= cost.length)
        {
            return 0;
        }
        if(dp[n] != -1)
        {
            return dp[n];
        }
        int a=minCostClimbingStairs(n+1,cost, dp)+cost[n];
        int b=minCostClimbingStairs(n+2,cost, dp)+cost[n];
        dp[n]=Math.min(a, b);
        return dp[n];
    }
    public static int minCostClimbingStairs(int [] cost){
        int n = cost.length;
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        int ans1= minCostClimbingStairs(0,cost, dp); //step with index 0
        int ans2= minCostClimbingStairs(1,cost, dp); //step with index 1
        return Math.min(ans1, ans2);
    }
}
