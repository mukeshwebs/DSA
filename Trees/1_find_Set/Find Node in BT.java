
//find the target node in the BT

TC: O(n)
SC: O(1)

    public static boolean find(TreeNode root, int data) {
        if (root == null) //if we reach to leaf node so return from there as we can not find the node
            return false; //explore other possibilitise

        if (root.val == data)  //if node is found return true
            return true;

        return find(root.left, data) || find(root.right, data);  //if either of the left or right call returns true then it will become true
    }
