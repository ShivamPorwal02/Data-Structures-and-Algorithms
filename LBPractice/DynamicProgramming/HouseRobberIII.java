package LoveBabbar.DynamicProgramming;

import java.util.HashMap;

public class HouseRobberIII {
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
    static HashMap<TreeNode,Integer> hm = new HashMap<>();
    public int rob(TreeNode node) {
        if(node==null) return 0;

        int lft = 0;
        if(hm.containsKey(node.left)) lft = hm.get(node.left);
        else{
            lft = rob(node.left);
            hm.put(node.left,lft);
        }
        int rgt = 0;
        if(hm.containsKey(node.right)) rgt = hm.get(node.right);
        else {
            rgt = rob(node.right);
            hm.put(node.right,rgt);
        }
        int size_incl = node.val;
        if (node.left!=null){
            int leftleft = 0;
            if(hm.containsKey(node.left.left)){
                leftleft = hm.get(node.left.left);
            }else{
                leftleft = rob(node.left.left);
                hm.put(node.left.left,leftleft);
            }
            int right =0;
            if(hm.containsKey(node.left.right)){
                right = hm.get(node.left.right);
            }else{
                right = rob(node.left.right);
                hm.put(node.left.right,right);
            }
            size_incl += leftleft+right;
        }
        if (node.right!=null){

            int leftleft = 0;
            if(hm.containsKey(node.right.left)){
                leftleft = hm.get(node.right.left);
            }else {
                leftleft = rob(node.right.left);
                hm.put(node.right.left,leftleft);
            }
            int right =0;
            if(hm.containsKey(node.right.right)){
                right = hm.get(node.right.right);
            }else {
                right = rob(node.right.right);
                hm.put(node.right.right,right);
            }
            size_incl += leftleft+right;
        }
        return Math.max(lft+rgt,size_incl);
    }
}
