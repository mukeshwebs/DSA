https://leetcode.com/problems/jump-game/

TC: O(n)
SCL O(1)
  
//Using Greedy Approach
/*
start from the last of the array 
using a flag finalIdx and traversing from last
if we are able to reach till the flag from the current index 
we will update the flag to current index
Note: in if condition we are checking the current max jump from current index excedds the flag index
*/


  class Solution {
    public boolean canJump(int[] nums) {
        int finalIdx = nums.length-1; // Last index ko finalIdx mein store karte hain
        for(int idx=nums.length-2; idx>=0; idx--){
            if(idx+nums[idx]>=finalIdx){ // Agar hum current index se final index tak jump kar sakte hain
                finalIdx = idx; // Toh finalIdx ko current index se replace karte hain
            }
        }
        return finalIdx==0; // Agar hum 0 par pahunch jaate hain, toh hum keh sakte hain ki hum jump kar sakte hain
    }
}

