package LoveBabbar.BinarySearchTree;

public class DeleteFromBST {
    int max;
    public SearchinBST.TreeNode deleteNode(SearchinBST.TreeNode root, int key) {
        max = Integer.MIN_VALUE;
        if(root==null) return null;

        if(key > root.val){
            root.right = deleteNode(root.right,key);
        }else if(key < root.val){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left!=null && root.right!=null){
                int leftMax = maximum(root.left);
                root.val = leftMax;
                root.left = deleteNode(root.left,leftMax);
            }else if(root.left!=null){
                return root.left;
            }else if(root.right!=null){
                return root.right;
            }else{
                return null;
            }
        }
        return root;
    }
    public int maximum(SearchinBST.TreeNode root){
        if(root==null) return 0;

        if(root.val>max) max = root.val;

        maximum(root.right);
        return max;
    }
}
