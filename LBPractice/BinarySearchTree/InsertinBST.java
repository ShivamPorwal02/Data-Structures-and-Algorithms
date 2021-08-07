package LoveBabbar.BinarySearchTree;

import LoveBabbar.BinaryTree.LevelOrderTraversal;

public class InsertinBST {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            TreeNode newNode  = new TreeNode(val);
            return newNode;
        }
        if(root.val==val) return root;  // agr equal hai to ni add krna
        if(root.val>val){
            root.left =  insertIntoBST(root.left,val);
        }else{
            root.right =  insertIntoBST(root.right,val);
        }
        return root;
    }
}
