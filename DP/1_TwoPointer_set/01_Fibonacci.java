// Recursive
class Solution {
    public int fib(int n) {
        return fib_rec(n);
    }
    
    public int fib_rec(int n){
        if(n == 0 || n == 1){
            return n;
        }

        int rec = fib_rec(n - 1) + fib_rec(n - 2);
        return rec;
    }
}

// Time Complexity: O(2^n) - Exponential time complexity, as each recursive call branches into two more calls.
// Space Complexity: O(n) - The maximum depth of the recursion stack is n.

___________________________________________________________________________________________________

// Memoization
class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return fib_memo(n, dp);
    }
    
    public int fib_memo(int n, int[] dp){
        if(n == 0 || n == 1){
            dp[n] = n;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int rec = fib_memo(n - 1, dp) + fib_memo(n - 2, dp);
        dp[n] = rec;
        return rec;
    }
}

// Time Complexity: O(n) - Each subproblem is solved only once, and there are n subproblems.
// Space Complexity: O(n) - The space required to store results of subproblems in the dp array.

___________________________________________________________________________________________________

// Tabulation
    public static int fibo_tabu(int N, int[] dp) {
        for (int n = 0; n <= N; n++) {
            if (n <= 1) {
                dp[n] = n;
                continue;
            }

            int ans = dp[n - 1] + dp[n - 2];// fibo_memo(n - 1, dp) + fibo_memo(n - 2, dp);
            dp[n] = ans;
        }

        return dp[N];
    }

// Time Complexity: O(n) - We iterate through the array once, solving each subproblem in a bottom-up manner.
// Space Complexity: O(n) - The space required to store results of subproblems in the dp array.
