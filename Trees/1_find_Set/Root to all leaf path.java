https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
/*
//problem statement
Given a Binary Tree of size n, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Input:
         10
       /    \
      20    30
     /  \
    40   60
    
Output: 
10 20 40 
10 20 60 
10 30 
*/

TC: O(n)
SC: O(n)

//NOTE: 
1.return type void for helper function
2.pass the result list and sublist both as a param, sublist inside function retuning wrong ans
3. as we have to explore other path as well so bactrack once reach to null //  if (root == null) return; currentPath.remove(currentPath.size() - 1);

------------------------------------------------------------------------------------------------------
class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        PathsHelper(root, currentPath, res);
        return res;
    }
    
    public static void PathsHelper(Node root, ArrayList<Integer> currentPath, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;

        // Add the current node's value to the current path
        currentPath.add(root.data);

        // If the current node is a leaf, add the current path to the result
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(currentPath));
        }
            // Recur for left and right subtrees
            PathsHelper(root.left, currentPath, res);
            PathsHelper(root.right, currentPath, res);

        // Backtrack: remove the last element to backtrack to the parent node
        currentPath.remove(currentPath.size() - 1);
    }
}
