package LoveBabbar.BinaryTree;

import java.util.ArrayList;

public class LeafSimilarTree_LeetCode {
    public boolean leafSimilar(LevelOrderTraversal.TreeNode root1, LevelOrderTraversal.TreeNode root2) {
        if(root1 == null && root2==null) return true;
        ArrayList<Integer> newLst = new ArrayList<>();
        ArrayList<Integer> lst1 = leafElement(root1,newLst);

        ArrayList<Integer> newLst2 = new ArrayList<>();
        ArrayList<Integer> lst2 = leafElement(root2,newLst2);


        return lst1.equals(lst2);
    }
    public ArrayList<Integer> leafElement(LevelOrderTraversal.TreeNode root, ArrayList<Integer> lst){
        if(root==null) return new ArrayList<>();
        if(root.left==null && root.right==null){
            lst.add(root.val);
        }
        leafElement(root.left,lst);
        leafElement(root.right,lst);
        return lst;
    }
}
