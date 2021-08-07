package LoveBabbar.Heap;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofBinaryTree {
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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;
        // basically ism h level order traversal krre hai aur jaise hi phla null mila wahi khtm ho jaana chahia agr usk baad bhi node hai to mtlb ni hai complete
        boolean end = false;

        Queue<TreeNode> q = new LinkedList<>();

        // ARRAYdeque doesnt allow null value to add
        // new LinkedList allows null value

        q.add(root);
        while(q.size()>0){
            TreeNode temp = q.remove();
            if(temp==null) end = true;
            else{
                if(end) return false;
                else{
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
        }
        return true;
    }
}
