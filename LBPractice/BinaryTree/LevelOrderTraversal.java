package LoveBabbar.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val= val;
        }
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> lst = new ArrayList<>();
        ArrayList<Integer> lst1 = new ArrayList<>();
        q.add(root);

        while(q.size()>0){
            int sizeofq = q.size();
            lst1 = new ArrayList<>();
            for(int i=0;i<sizeofq;i++){
                TreeNode rem = q.remove();
                lst1.add(rem.val);

                if(rem.left!=null) q.add(rem.left);
                if(rem.right!=null) q.add(rem.right);
            }
            lst.add(lst1);
        }
        return lst;
    }
}
