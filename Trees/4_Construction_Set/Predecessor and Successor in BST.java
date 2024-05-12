https://www.geeksforgeeks.org/problems/predecessor-and-successor/1


public static void findPreSuc(Node root, int key)
{
    if(root==null) return;
    
    if(root.data==key){
        
        //pre - left subtree ka rightmost node
        if(root.left!=null){
            Node temp_a = root.left;
            while(temp_a.right!=null){
                temp_a = temp_a.right;
            }
            pre = temp_a;          
        }
        
        //succ - right subtree ka leftmost node 
        if(root.right!=null){
            Node temp_b = root.right;
            while(temp_b.left!=null){
                temp_b = temp_b.left;
            }  
            suc = temp_b;       
        }
         return;
    }
    
    if(root.data>key){
        suc = root;
        findPreSuc(root.left, key);
    }else{
        pre = root;
        findPreSuc(root.right, key);
    }
