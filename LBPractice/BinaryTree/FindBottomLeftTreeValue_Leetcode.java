package LoveBabbar.BinaryTree;

import java.util.ArrayList;

public class FindBottomLeftTreeValue_Leetcode {
    public int findBottomLeftValue(LevelOrderTraversal.TreeNode root) {
        ArrayList<Integer> lst = new ArrayList<>();
        leftview(root,lst,0);
        return lst.get(lst.size()-1);
    }
    public void leftview(LevelOrderTraversal.TreeNode root, ArrayList<Integer> lst, int depth){
        if(root==null) return ;

        if(lst.size()==depth){
            lst.add(root.val);
        }
        leftview(root.left,lst,depth+1);
        leftview(root.right,lst,depth+1);
    }
}
