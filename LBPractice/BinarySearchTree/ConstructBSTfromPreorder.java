package LoveBabbar.BinarySearchTree;

public class ConstructBSTfromPreorder {
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
    int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstInorder(preorder,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public TreeNode bstInorder(int[] preorder, long min, long max){
        if(idx>=preorder.length || preorder[idx] <= min || preorder[idx] >=max){
            return null;
        }

        TreeNode node = new TreeNode(preorder[idx]);
        idx++;

        node.left = bstInorder(preorder,min,node.val);
        node.right = bstInorder(preorder,node.val,max);
        return node;
    }
}
