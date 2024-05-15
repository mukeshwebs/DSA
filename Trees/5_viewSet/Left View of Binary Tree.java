https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1


public static void leftView(TreeNode root) {
    LinkedList<TreeNode> que = new LinkedList<>(); // Queue for BFS traversal
    que.addLast(root); // Root node ko queue mein daal do

    ArrayList<Integer> ans = new ArrayList<>(); // List jisme left view ke nodes store honge
    while (que.size() != 0) { // Jab tak queue mein nodes hain
        int size = que.size(); // Queue ki current size le lo
        ans.add(que.getFirst().val); // Pehle queue ke node ka value result mein daalo (ye current level ka leftmost node represent karta hai)
        while (size-- > 0) { // Current level ke nodes ko process karo
            TreeNode rn = que.removeFirst(); // Queue se pehla node hatao aur usko process karo

            // Current node ke left aur right children ko queue mein daalo
            if (rn.left != null)
                que.addLast(rn.left);
            if (rn.right != null)
                que.addLast(rn.right);
        }
    }
}

