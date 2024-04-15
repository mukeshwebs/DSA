https://www.geeksforgeeks.org/problems/size-of-binary-tree/1
/*
//problem statement
Example 2:
Input:
10 5 9 N 1 3 6 
Output:
6
Explanation:
Given Tree is :
                              10
                             /  \
                           5     9
                            \    / \
                             1 3   6
There are 6 nodes in the tree.

*/

TC: O(n)
SC: O(1)


Note: size is no. of nodes in the binary tree
     O
    / \
   -   -
 ->  leftres+rightres+1 , 1 for root node 
-----------------------------------------------------------
class Tree
{
	public static int getSize(Node root)
	{
	    if(root==null){
	        return 0;
	    }
	    int lsize = getSize(root.left);
	    int rsize = getSize(root.right);
	    
	    int res = lsize+rsize+1;
	    return res;
    }
}
--------------------------------------------------------
  //same code as above
  
class Solution {
	public static int getSize(Node root)
	{
	    if(root==null) return 0;
	    return getSize(root.left)+getSize(root.right)+1;
    }
}  
