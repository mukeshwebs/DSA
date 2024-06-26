https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

Logic: nodeToRootPath find kro dono given p and q nodes se unme se jo common node hoga wahi LCA hoga
  TC: O(n)
  SC: O(n)
  
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<Integer> path_a = new ArrayList<>();
        ArrayList<Integer> path_b = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        NodetoRootPath(root, p.val, path_a);
        NodetoRootPath(root, q.val, path_b);
        // Store all nodes in path_a into the set
        for(int i : path_a){
            set.add(i);
        }
        // Traverse through path_b, if any node matches with a node in set, return that node
        for(int j : path_b){
            if(!set.add(j)){
                // If a node is found in path_b that is also in path_a, it's the LCA
                return new TreeNode(j); // Assuming a TreeNode constructor exists
            }
        }
        // Return null if no common ancestor found
        return null;
        
    }
    //return the node to root path 
    public boolean NodetoRootPath(TreeNode root, int data, ArrayList<Integer> list){
        if(root==null){
            return false;
        }
        if(root.val==data){
            list.add(root.val);
            return true;
        }

        if(NodetoRootPath(root.left, data, list) || NodetoRootPath(root.right, data, list)){
            // return true; # mistake 1
            list.add(root.val);
            return true;
        }
        return false;
    }
}

----------------------------------------
  //optimised - TC: O(n), SC: O(1)
  class Solution {
    TreeNode LCANode = null;
    public boolean lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return false;
        boolean selfPresent = root==p || root==q;

        boolean leftPresent = lowestCommonAncestorHelper(root.left, p, q);
        boolean rightPresent = lowestCommonAncestorHelper(root.right, p, q);
        /*
        case1: (leftPresent && rightPresent) : if leftside is true and rightside is true means root is the LCA
        case2: if leftside node is found and current node is present then root and vice versa
        */
        if((leftPresent && rightPresent) || (leftPresent && selfPresent) || (selfPresent && rightPresent)){
            LCANode = root;
        }
        return leftPresent||rightPresent||selfPresent;
    }    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorHelper(root, p, q);
        return LCANode;
    }
}
