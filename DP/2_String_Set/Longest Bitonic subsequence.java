https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1

TC: O(n)^2
SC:O(n) 

/*

Input: nums = [1, 2, 5, 3, 2]
Output: 5
Explanation: The sequence {1, 2, 5} is
increasing and the sequence {3, 2} is 
decreasing so merging both we will get 
length 5.

Logic: using standard LIS for left to right and for finding the LIS_RL outer for loop is starting from end 
*/
  
class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        int n = arr.length, maxLen = 0;
        int[] LIS = new int[n];
        int[] LDS = new int[n];

        LIS_LR(arr, LIS);
        LIS_RL(arr, LDS);

        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, LIS[i] + LDS[i] - 1);  //-1 bcz dono me 1 length common hai 
        }
        return maxLen;   
    }
  
    public static int LIS_LR(int[] arr, int[] dp) {    //standard LIS code, at each index from starting we finding the numbr of LIS  [1, 2, 5, 3, 2] -> {1, 2, 5}
        int n = arr.length, maxLen = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {             //NOTE: if condition is same for both in case of LR 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(dp[i], maxLen);
        }

        return maxLen;
    }

  [1, 2, 5, 3, 2] -> {3, 2}

    public static int LIS_RL(int[] arr, int[] dp) {   //  Right to left -> means from last to first          
        int n = arr.length, maxLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {            //NOTE: if condition is same for both in case of RL
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}
