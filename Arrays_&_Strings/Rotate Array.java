https://leetcode.com/problems/rotate-array/description/

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if(k>nums.length){ //if k is greater than array length 
            k = k%n;   
        }
        /*
        ex: nums = [1,2,3,4], k = 5
        Output: 
        */
        //3 times reverse
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);        
        reverse(nums, 0, n-1); 
    }
    public static void reverse(int [] nums, int low, int high){
        while(low<=high){
            //swap the values 
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            low++;
            high--;
        }
    }
}


