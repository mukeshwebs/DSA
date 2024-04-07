https://leetcode.com/problems/climbing-stairs/

//recursion_

    public int climbStairsHelper(int n, int idx) {
        if (idx == n) { // if we reach to the last index, we found 1 ways
            return 1;
        }
      
        if (idx > n) { //if current 1 jump steps + 2 steps jumps exceed the last step then return 0 from it
            return 0;
        }

        int way_a = climbStairsHelper(n, idx + 1);  //can jump 1 steps at a time
        int way_b = climbStairsHelper(n, idx + 2);  //can jump 2 steps at a time
        return way_a + way_b;
    }

//dp - memoization 

    public int climbStairsHelper(int n, int[]dp, int idx){
        //base case 
        if(idx==n){ //reached at last steps, no futher steps reuquired 
        return dp[n] = 1;
        }
        if(idx>n){
            return 0;
        }

        if(dp[idx]!=-1){
            return dp[idx];
        }
        
        int way_a = climbStairsHelper(n, dp, idx+1);
        int way_b = climbStairsHelper(n, dp, idx+2);
        dp[idx] = way_a+way_b;
        return dp[idx];
    }

