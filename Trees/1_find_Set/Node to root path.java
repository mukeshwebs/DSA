/*
              1
            /   \
            2     3
          /  \   /  \
         4    5  6   7

         pathList: [5,2, 1]
 */


    //Note: node to -> root so we will form answer when node is found
/*
once root.val==data just add in the list and return true 
we will start building answer from here so in stack the call which made it to target node 
that will get true result and we will check for the  -> root.left and root.right which one
is true that will be added so by this way tree will start storing the answers from that node to the top.
*/

Note: 2 rturn types possible boolean and arraylist

  //return type boolean
  
    public boolean NodetoRootPath(TreeNode root, int data, ArrayList<Integer> list){
        if(root==null){
            return false; 
        }
        if(root.val==data){  //if nod
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
---------------------------------------------------------------------------------------------------
//return type arralist 

    ArrayList<TreeNode> nodeToRootPath_(TreeNode root, int data) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.val == data) {
            ArrayList<TreeNode> base = new ArrayList<>();
            base.add(root);
            return base;
        }

        ArrayList<TreeNode> left = nodeToRootPath_(root.left, data);
        if (left.size() != 0) {
            left.add(root);
            return left;
        }

        ArrayList<TreeNode> right = nodeToRootPath_(root.right, data);
        if (right.size() != 0) {
            right.add(root);
            return right;
        }

        return new ArrayList<>();
    }
