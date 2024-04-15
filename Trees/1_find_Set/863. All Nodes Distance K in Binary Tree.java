https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

/*
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
         3
       /   \
      5     1
     / \   / \
    6   2 0   8
       / \
      7   4

      [7,4,1]

          */

//important helper function used
1.KDown
2.nodeToRootPath
3. traverse on node to root path and block nodes

//without comments 
class Solution {
     boolean nodeToRootPath_(TreeNode root, int data, ArrayList<TreeNode> ans) {

        if (root == null)
            return false;

        if (root.val == data) {
            ans.add(root);
            return true;
        }

        boolean res = nodeToRootPath_(root.left, data, ans) || nodeToRootPath_(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }   

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath_(root, target.val, path);

        List<Integer> ans = new ArrayList<>();
        TreeNode block = null;
        for (int i = 0; i < path.size(); i++) {
            kdown(path.get(i), k - i, block, ans);
            block = path.get(i);
        }
        return ans;
    }

    public void kdown(TreeNode root, int k, TreeNode block, List<Integer> ans) {

        if (root == null || k < 0 || root == block)
            return;

        if (k == 0) {
            ans.add(root.val);
            return;
        }

        kdown(root.left, k - 1, block, ans);
        kdown(root.right, k - 1, block, ans);
    }   
}


//with commments 
class Solution {
     boolean nodeToRootPath_(TreeNode root, int data, ArrayList<TreeNode> ans) {

        if (root == null)
            return false;

        if (root.val == data) {
            ans.add(root);
            return true;
        }
        boolean res = nodeToRootPath_(root.left, data, ans) || nodeToRootPath_(root.right, data, ans);

        if (res)
            ans.add(root);
        return res;
    }   
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRootPath_(root, target.val, path);

        List<Integer> ans = new ArrayList<>();
        TreeNode block = null;
        for (int i = 0; i < path.size(); i++) {
            kdown(path.get(i), k - i, block, ans);
            block = path.get(i);
        }
        return ans;
    }



     /*
Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
         3
       /   \
      5     1
     / \   / \
    6   2 0   8
       / \
      7   4

      [7,4,1]

          */
     //ye current node se k nodes niche jaayega
     public void kdown(TreeNode root, int k, TreeNode block, List<Integer> ans) {
          //block node is important here because it will help in traversing the above nodes at k distance 
          //in the above tree one of the possible ans node is '1' so how we get that??
          //first we calculate the nodetoRoot path that give -> [2, 5, 3] ->traverse on this -> by calling k down so once we reach at 3-> kdown will result 1
          //as at that point k will be getting reduced by k-i
          
        if (root == null || k < 0 || root == block) //if root is null, ya k zero ho jaaye
            return;

        if (k == 0) {
            ans.add(root.val); //agr last node pe chle gye to ans me wo node add kr do 
            return;
        }

        kdown(root.left, k - 1, block, ans); //reduce k each time
        kdown(root.right, k - 1, block, ans);
    }   
}
