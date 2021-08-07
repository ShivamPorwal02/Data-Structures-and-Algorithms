package LoveBabbar.BinaryTree;

public class DiameterofBinaryTree {
    static int max;
    public int diameterOfBinaryTree(LevelOrderTraversal.TreeNode root) {
        max = 0;
        diameter(root);
        return max;
    }
    public int diameter(LevelOrderTraversal.TreeNode root){
        if(root==null) return -1;
        int diaLeft = diameter(root.left);
        int diaRight = diameter(root.right);
        max=Math.max(diaLeft+diaRight+2,max);
        return 1+Math.max(diaLeft,diaRight);
    }
}
