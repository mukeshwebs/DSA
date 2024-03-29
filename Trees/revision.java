
// Node to Root || Root to Node path 

//NodeToRootPath
//forming answer from bottom to top ..

    boolean nodeToRootPath_(TreeNode root, int data, ArrayList<TreeNode> ans) {

        if (root == null)
            return false;

        if (root.val == data) {
            ans.add(root);
            return true;
        }

        // if (nodeToRootPath_(root.left, data, ans))
        // {
        // ans.add(root);
        // return true;
        // }

        // if (nodeToRootPath_(root.right, data, ans))
        // {
        // ans.add(root);
        // return true;
        // }

        // return false;

        boolean res = nodeToRootPath_(root.left, data, ans) || nodeToRootPath_(root.right, data, ans);

        if (res==true)
            ans.add(root);
        return res;
    }


//RootToNodePath
//forming answer from top to bottom...




