package LoveBabbar.BinarySearchTree;

public class isBST {
    class Node{
        int data;
        Node left;
        Node right;
    }
    class BSTPair{
        boolean isBST;
        long min;
        long max;
        BSTPair(){

        }
        BSTPair(boolean isBST,long min,long max){
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    BSTPair IsBST(Node root){
        if(root==null) {
            BSTPair bp = new BSTPair(true,Long.MAX_VALUE,Long.MIN_VALUE);
            return bp;
        }
        BSTPair lp = IsBST(root.left);
        BSTPair rp = IsBST(root.right);

        BSTPair mp = new BSTPair();

        mp.isBST = lp.isBST && rp.isBST && (root.data>lp.max && root.data < rp.min);

        mp.min = Math.min(root.data,Math.min(lp.min,rp.min));
        mp.max = Math.max(root.data,Math.max(lp.max,rp.max));

        return mp;
    }



    boolean isBST(Node root)
    {
        // code here.
        BSTPair ans = IsBST(root);
        return ans.isBST;
    }
    public boolean isValidBST_(SearchinBST.TreeNode root) {
        return helper(root, null, null);
    }

    boolean helper(SearchinBST.TreeNode root, Integer min, Integer max) {
        if (root == null)
            return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max))
            return false;

        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}
