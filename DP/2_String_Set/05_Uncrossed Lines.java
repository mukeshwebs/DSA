https://leetcode.com/problems/uncrossed-lines/description/

/*
Input: nums1 = [1,4,2], nums2 = [1,2,4]
Output: 2
Explanation: We can draw 2 uncrossed lines as in the diagram.
We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
*/  


Time Complexity: O(n * m)
Space Complexity: O(n * m)

###############################################################################################################

class Solution {
    public int maxUncrossedLinesHelper(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        // base case
        if (n == 0 || m == 0) {
            return 0;
        }
        // memoization
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        // check if the values at the current indices are equal
        if (nums1[n - 1] == nums2[m - 1]) {

            /*it implies that you have found a pair of elements that can be part of an uncrossed line. 
            By adding +1, you are incrementing the count of uncrossed lines by 1.*/
            
            return dp[n][m] = 1 + maxUncrossedLinesHelper(nums1, nums2, n - 1, m - 1, dp); /
        } else {
            // make two recursive calls
            int option1 = maxUncrossedLinesHelper(nums1, nums2, n - 1, m, dp);
            int option2 = maxUncrossedLinesHelper(nums1, nums2, n, m - 1, dp);

            // return the maximum value obtained from the recursive calls
            return dp[n][m] = Math.max(option1, option2);
        }
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return maxUncrossedLinesHelper(nums1, nums2, n, m, dp);
    }
}
