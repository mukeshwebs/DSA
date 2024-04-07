https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

/*
Time Complexity: O(n * m)
Space Complexity: O(n * m)
*/

start mining from the last col and for last col value will be as it is and in last 2nd col for top row and most bottom row it can travel forward and \(top)  /(bottom)
and for anywhere in between it can travel in 3 direction so everytime to get the max gold we will pick max of all possible movement and then add with the current values.

at last simply check the first col of each row and find the max value, so that will be the answer.
---------------------------------------------------------------------------------------------------------------
  
  
class Solution {
    static int maxGold(int n, int m, int arr[][]) {
        int row = arr.length;
        int col = arr[0].length;
        int[][] dp = new int[row][col];
        
        //base case 
        if(n==1){
            int sum = 0;
            for(int j = 0; j < m; j++){
                sum+=arr[0][j];
            }
            return sum;
        }

        for (int j = arr[0].length - 1; j >= 0; j--) {
            for (int i = arr.length - 1; i >= 0; i--) {

                // If it is in the last column, then cannot mine more so just adjust the value
                if (j == arr[0].length - 1) {
                    dp[i][j] = arr[i][j];
                } else if (i == row - 1) {
                    if(row>1){
                       dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                    }else{
                        dp[i][j] = arr[i][j];
                    }
                } else if (i == 0) {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else {
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j + 1], Math.max(dp[i + 1][j + 1], dp[i - 1][j + 1]));
                }
            }
        }

        // Find the maximum value in the first column
        int max = dp[0][0];
        for (int i = 1; i < row; i++) {
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        return max;
    }
}



