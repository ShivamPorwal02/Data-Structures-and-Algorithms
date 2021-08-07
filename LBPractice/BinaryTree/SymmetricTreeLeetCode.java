package LoveBabbar.BinaryTree;

public class SymmetricTreeLeetCode {
    public boolean isSymmetric(LevelOrderTraversal.TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    public boolean isMirror(LevelOrderTraversal.TreeNode r1, LevelOrderTraversal.TreeNode r2){
        if(r1==null && r2==null) return true;
        else if(r1==null && r2!=null || r1!=null && r2==null) return false;
        else if(r1.val!=r2.val) return false;
        return isMirror(r1.left,r2.right) && isMirror(r1.right,r2.left);
    }
}
