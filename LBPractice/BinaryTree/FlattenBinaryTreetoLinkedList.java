package LoveBabbar.BinaryTree;

public class FlattenBinaryTreetoLinkedList {
    public void flatten(LevelOrderTraversal.TreeNode root) {
        if(root==null) return;

        LevelOrderTraversal.TreeNode left = root.left;
        LevelOrderTraversal.TreeNode right = root.right;

        root.left = null;


        flatten(left);
        flatten(right);

        root.right = left;

        LevelOrderTraversal.TreeNode curr = root;
        while(curr.right!=null) curr = curr.right;

        curr.right = right;
    }
}
