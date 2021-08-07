package LoveBabbar.BinarySearchTree;

public class ConstructBSTfromInOrder {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode BSTfromInorder(int[] inorder){
        int len = inorder.length-1;
        return BSTInorder(inorder,0,len);
    }
    public static TreeNode BSTInorder(int[] inorder, int start,int end){
        if (start>end) {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(inorder[mid]);

        node.left = BSTInorder(inorder,start,mid-1);
        node.right = BSTInorder(inorder,mid+1,end);
        return node;
    }
}
