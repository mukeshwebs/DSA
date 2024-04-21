https://leetcode.com/problems/binary-tree-inorder-traversal/

Logic: inorder traversal stored in list -> next return the current node -> hasNext return is itr is in range 
class BSTIterator {
    ArrayList<Integer> res = new ArrayList<>(); //global variable
    int itr = 0;
    public void inorderTraversalHelper(TreeNode root, ArrayList<Integer> res) {
        if(root==null) return; //base case 

        inorderTraversalHelper(root.left, res);
        res.add(root.val);
        inorderTraversalHelper(root.right, res);
    }        
    public BSTIterator(TreeNode root) {
        // if(root==null) return res;
        inorderTraversalHelper(root,res);        
    }
    public int next() {

        int ans = 0;
        ans = res.get(itr);
        itr++;
        return ans;
    }
    public boolean hasNext() {
        return itr < res.size();
    }
}
