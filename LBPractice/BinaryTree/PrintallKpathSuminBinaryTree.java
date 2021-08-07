package LoveBabbar.BinaryTree;

import java.util.ArrayList;

public class PrintallKpathSuminBinaryTree {
    ArrayList<String> lst;
    public int pathSum(LevelOrderTraversal.TreeNode root, int targetSum) {
        if(root==null) return 0;
        int left = pathSum(root.left,targetSum); // ye hrr node prr jaaega left k
        int right = pathSum(root.right,targetSum); // similarly right prr ye sock ki m hi root hoon merese koi path to ni aara
        int goingToFind = sum(root,targetSum,0,""); // ye usss path ko dhundne k lia hai ki usse koi hai kya path
        System.out.println(lst);
        return left+right+goingToFind;
    }
    public int sum(LevelOrderTraversal.TreeNode root, int target, int sum, String psf){
        if(root==null){
            return 0;
        }
        int res = 0;
        sum = sum+root.val;
        if(sum==target) {
            lst.add(psf+root.val+"");
            res++;
        }
        res+=sum(root.left,target,sum,psf+root.val+"->");
        res+=sum(root.right,target,sum,psf+root.val+"->");

        // if(sum==target) cnt++;

        return res;
    }
}
