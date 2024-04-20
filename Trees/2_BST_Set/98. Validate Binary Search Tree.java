https://leetcode.com/problems/validate-binary-search-tree/

TC: O(n)
SC: O(1)

/*
Note: 
check for the invalid cases
*/
  
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE); //taking long because of the contraints 
    }
    public boolean isValidBSTHelper(TreeNode root, long min, long max){ //min and max is the range of the current node
        if(root==null) return true;
        if(root.val<=min || root.val>=max){  //if the current node value is less than min possible value and vice versa
            return false;
        }
      // in the left call update the right range, root ke value se bdi value nhi honi chaniye
      //in the right call update the left range, root ke value se choti value nhi honi chahiye
        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right,root.val,max); 
    }
}
