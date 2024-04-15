https://www.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1

/*
Given a Binary Tree, find maximum and minimum elements in it.
         10
        /  \
       5    15
      / \   / \
     3   8 12  20

        root
   /           \
leftRecRes rightRecRes

max of -> root, leftRecRes, rightRecRes

*/
TC: O(n)
SC: O(1)
------------------------------------------------------------------------
class Solution{
    public static int findMax(Node root){
        //inorder -> left, root, right
        int max_val = Integer.MIN_VALUE;
        if(root==null) return max_val;
        return Math.max(root.data, Math.max(findMax(root.left),findMax(root.right))); //finding the max in root, left recres and right recres
    }
    public static int findMin(Node root){
        int min_val = Integer.MAX_VALUE;
        if(root==null) return min_val;
        return Math.min(root.data, Math.min(findMin(root.left),findMin(root.right)));
    }
}
