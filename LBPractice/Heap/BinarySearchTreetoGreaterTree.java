package LoveBabbar.Heap;

public class BinarySearchTreetoGreaterTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        bstToGST(root);
        return root;
    }
    public int bstToGST(TreeNode root){
        if(root==null) return 0;
        bstToGST(root.right);
        sum+=root.val;
        root.val = sum;
        bstToGST(root.left);
        return sum;
    }
}
