https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article


//User function Template for Java
//memoization

class Solution {
    static Boolean isSubsetSum(int N, int arr[], int sum) {
        // Create a memoization array to store the results of subproblems
        Boolean[][] memo = new Boolean[N + 1][sum + 1];
        // Initialize the memoization array with null values
        for (int i = 0; i <= N; i++) {
            Arrays.fill(memo[i], null);
        }
        // Call the helper function with memoization
        return isSubsetSumHelper(arr, N, sum, memo);
    }

    public static boolean isSubsetSumHelper(int[] arr, int idx, int targetSum, Boolean[][] memo) {
        // Base cases
        if (targetSum == 0) {
            return true;
        }
        if (idx == 0 || targetSum < 0) {
            return false;
        }
        // If result for current subproblem is already computed, return it from memoization array
        if (memo[idx][targetSum] != null) {
            return memo[idx][targetSum];
        }
        // Recursively check if target sum can be achieved by including or excluding current element
        boolean include = isSubsetSumHelper(arr, idx - 1, targetSum - arr[idx - 1], memo);
        boolean exclude = isSubsetSumHelper(arr, idx - 1, targetSum, memo);
        // Store the result in memoization array and return
        return memo[idx][targetSum] = include || exclude;
    }
}

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
  //Tabulation

  
