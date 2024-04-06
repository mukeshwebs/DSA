https://leetcode.com/problems/jump-game-ii/description/

TC: O(n)
SC: O(1)
  
/*
Iss code mein hum ek loop chalate hain tak tab tak jab tak hum last tak nahi pahunchte. 
Har iteration mein hum yeh dekhte hain ki current range mein hum sabse door tak kaise pahunch sakte hain. 
Phir hum current range ke baad ka next range decide karte hain. Jab hum last tak pahunch jaate hain, tab hum jump count ko return karte hain.
*/
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int jump = 0;

        while (right < n - 1) {
            // Har iteration mein hum sabse aage tak kaise pahunch sakte hain woh dekhte hain
            int farthestPoint = right;

            // Current range mein har ek point par jaakar dekhte hain, aur sabse door tak kis point tak ja sakte hain
            for (int i = left; i <= right; i++) {
                farthestPoint = Math.max(farthestPoint, i + nums[i]);
            }

            // Current range ke baad agla range decide karte hain
            left = right + 1; // Left ko current right ke baad ka point kar do
            right = farthestPoint; // Right ko sabse door tak pahunchne wale point par set kar do
            jump++; // Har jump ko count karo
        }

        return jump; // Jump count ko return karo
    }
}

