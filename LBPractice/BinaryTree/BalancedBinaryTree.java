package LoveBabbar.BinaryTree;

public class BalancedBinaryTree {
    public boolean isBalanced(LevelOrderTraversal.TreeNode root) {
        if(root==null) return true;
        boolean left = isBalanced(root.left);
        if(left==false) return false;
        boolean right = isBalanced(root.right);
        if(right==false) return false;
        return Math.abs(height(root.left)-height(root.right))<=1;
    }
    public int height(LevelOrderTraversal.TreeNode root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}
