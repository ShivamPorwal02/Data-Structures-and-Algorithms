package LoveBabbar.BinaryTree;

public class SameTree {
    public boolean isSameTree(LevelOrderTraversal.TreeNode p, LevelOrderTraversal.TreeNode q) {
        if(p==null && q==null) return true;
        else if(p==null && q!=null || q==null && p!=null) return false;
        else if(p.val!=q.val) return false;
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
