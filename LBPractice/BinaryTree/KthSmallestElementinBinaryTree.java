package LoveBabbar.BinaryTree;

public class KthSmallestElementinBinaryTree {
    static int ceil;
    public int kthSmallest(LevelOrderTraversal.TreeNode root, int k) {
        ceil = Integer.MAX_VALUE;
        int factor = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            factor = findCeil(root,factor);
            ceil = Integer.MAX_VALUE;
        }
        return factor;
    }
    public int findCeil(LevelOrderTraversal.TreeNode root, int data){
        if(root == null) return ceil;

        if(root.val>data && root.val<ceil){
            ceil = root.val;
        }
        findCeil(root.left,data);
        findCeil(root.right,data);
        return ceil;
    }
}
