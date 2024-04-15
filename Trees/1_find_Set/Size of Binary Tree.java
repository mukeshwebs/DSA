https://www.geeksforgeeks.org/problems/size-of-binary-tree/1

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
