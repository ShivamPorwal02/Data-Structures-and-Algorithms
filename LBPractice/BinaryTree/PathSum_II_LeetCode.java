package LoveBabbar.BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSum_II_LeetCode {
    List<List<Integer>> lst;
    public List<List<Integer>> pathSum(LevelOrderTraversal.TreeNode root, int targetSum) {
        lst = new ArrayList<>();
        List<Integer> smallst = new ArrayList<>();
        sum(root,targetSum,0,smallst);

        return lst;
    }
    public void sum(LevelOrderTraversal.TreeNode root, int target, int sum, List<Integer> psf){
        if(root==null) return ;

        sum= sum +root.val;
        psf.add(root.val);

        sum(root.left,target,sum,psf);
        sum(root.right,target,sum,psf);

        if(sum==target  && root.left==null && root.right==null){
            ArrayList<Integer> cloneLst = new ArrayList<>();
            for(int num : psf){
                cloneLst.add(num);
            }
            lst.add(cloneLst);
            psf.remove(psf.size()-1);
            return;
        }

        psf.remove(psf.size()-1);

        return;
    }
}
