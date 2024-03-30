https://leetcode.com/problems/jump-game/

TC: O(n)
SCL O(1)
  
//without comments
public class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums, nums.length);
    }
    
    public boolean canJump(int[] A, int n) {
        int last = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + A[i] >= last) {
                last = i;
            }
        }
        return last <= 0;
    }
}

XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//with comments
public class Solution {
    // Method to check if it is possible to reach the last index of the array from the first index
    public boolean canJump(int[] nums) {
        return canJump(nums, nums.length);
    }

    public boolean canJump(int[] A, int n) {
        // Initialize the last reachable index to the end of the array
        int last = n - 1;
        // Iterate through the array from the second last element to the first
        for (int i = n - 2; i >= 0; i--) {
            // Check if it's possible to reach the last index from the current index
            //A[i] :  tell how many jumps we can take from current index
            if (i + A[i] >= last) {
                // Update last to the current index if it's possible to reach the end from here
                last = i;
            }
        }
        // If last index is reachable from the first index (or any index), return true, otherwise false
        return last <= 0;
    }
}
