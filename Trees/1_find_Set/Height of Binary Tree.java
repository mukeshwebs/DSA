https://www.geeksforgeeks.org/problems/height-of-binary-tree/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
----------------------------------------------------------------------
/*
Given a binary tree, find its height.

Example 1:

Input:
     1
    /  \
   2    3
Output: 2
 */

TC: O(n)
SC: O(1)
----------------------------------------------------------------------
class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        //base case 
        if(node==null){
            return 0;
        }
        // code here
        int lheight = height(node.left);
        int rheight = height(node.right);
        int res = Math.max(lheight, rheight)+1;
        
        return res;
    }
}
----------------------------------------------------------------------
class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        if(node==null) return 0;
        // code here 
        return Math.max(height(node.left),  height(node.right))+1;
    }
}
----------------------------------------------------------------------
