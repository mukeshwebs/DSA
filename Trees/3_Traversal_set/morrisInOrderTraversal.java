https://leetcode.com/problems/binary-tree-inorder-traversal/

TC: O(n)
SC: O(1)

  NOTE: Morris inorder traversal doesn't uses stack to iterate and backtrack it uses curr and left pointer
  ---------------------
  print:
    when left is null
    when thread is used 

  left:
  thread is created
  ---------------------
  right:
  thread is destoryed -> rightmostNode.right == null -> make right traversal to explore the nodes in right to the curr node
  ---------------------

   //using morris traversal 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        return morrisInOrderTraversal(root);
    }
      public static TreeNode getRightMostNode(TreeNode node, TreeNode curr) {
        while (node.right != null && node.right != curr) { //node.right curr ke equal ho gya to infi loop will create
            node = node.right;
        }
        return node;
    }
    public static ArrayList<Integer> morrisInOrderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;
        while (curr != null) {
            TreeNode left = curr.left;
            if (left == null) {
                ans.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(left, curr);
                if (rightMostNode.right == null) { // thread creation block
                    rightMostNode.right = curr; // thread is created
                    curr = curr.left;
                } else { // thread destroy block
                    rightMostNode.right = null; // thread is cut down

                    ans.add(curr.val);

                    curr = curr.right;
                }
            }
        }

        return ans;
    }      
}
