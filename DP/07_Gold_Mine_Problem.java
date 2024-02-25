https://www.geeksforgeeks.org/problems/gold-mine-problem2608/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

class Solution {
    static int maxGold(int n, int m, int arr[][]) {
        // code here
        int[][] dir = {{0, 1}, {1, -1}, {-1, 1}};
        int[][] dp = new int[n][m];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int maxGold = 0;
        for (int r = 0; r < n; r++) {
            // Corrected the following line by replacing "maxGold(sr, 0, arr, dir, dp)"
            // with "maxGold(r, 0, arr, dir, dp)"
            maxGold = Math.max(maxGold, maxGold(r, 0, arr, dir, dp));
        }
        return maxGold;
    }

    public static int maxGold(int sr, int sc, int arr[][], int[][] dir, int[][] dp) {
        // base case
        int n = arr.length;
        int m = arr[0].length;

        // if we are in the last column, values should be filled as it is, so this is the base case
        if (sc == m - 1) {
            return dp[sr][sc] = arr[sr][sc];
        }

        // memo - already calculated
        if (dp[sr][sc] != -1) { // Corrected from "dp[sr][sc] != 0"
            return dp[sr][sc];
        }

        int maxGold = 0;
        // direction array used - it will check in all 3 directions from the current iteration
        // and the maxGold path will be chosen, adding the current values
        for (int d=0; d<dir.length; d++) {
            int r = sr + dir[d][0]; 
            int c = sc + dir[d][0]; 

            // make safe calls
            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
                // Corrected the following line by replacing "maxGold(r, c, arr, dir, dp) + arr[sr][sc]"
                // with "maxGold(r, c, arr, dir, dp) + arr[r][c]"
                maxGold = Math.max(maxGold, maxGold(r, c, arr, dir, dp) + arr[sr][sc]);
            }
        }
        return dp[sr][sc] = maxGold; // Corrected from "return dp[sr][sc];"
    }
}
