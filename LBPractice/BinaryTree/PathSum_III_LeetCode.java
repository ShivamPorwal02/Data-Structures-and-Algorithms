package LoveBabbar.BinaryTree;

import java.util.HashMap;

public class PathSum_III_LeetCode {

    // ye hrr node prr jaari hai O(n2) hai

    // video link --> https://www.youtube.com/watch?v=uZzvivFkgtM // dekhlena recommend hai ism subtree ka bhi thoda bola hai usse optimixr ho jaaega udr bhi
    public int pathSum(LevelOrderTraversal.TreeNode root, int targetSum) {
        if(root==null) return 0;
        int left = pathSum(root.left,targetSum); // ye hrr node prr jaaega left k
        int right = pathSum(root.right,targetSum); // similarly right prr ye sock ki m hi root hoon merese koi path to ni aara
        int goingToFind = sum(root,targetSum,0); // ye usss path ko dhundne k lia hai ki usse koi hai kya path
        return left+right+goingToFind;
    }
    public int sum(LevelOrderTraversal.TreeNode root, int target, int sum){
        if(root==null){
            return 0;
        }
        int res = 0;
        sum = sum+root.val;
        if(sum==target) res++;
        res+=sum(root.left,target,sum);
        res+=sum(root.right,target,sum);

        // if(sum==target) cnt++;

        return res;
    }

    // METHOD2  PREFIX ARRAY SUM se krdia

    public int pathSum_(LevelOrderTraversal.TreeNode root, int targetSum) {
        if(root==null) return 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        return pathSum2(root,0,targetSum,hm);
    }
    public int pathSum2(LevelOrderTraversal.TreeNode root, int runingSum, int target, HashMap<Integer,Integer> hm){
        if(root==null){
            return 0;
        }
        runingSum+=root.val;

        int cnt = hm.getOrDefault(runingSum-target,0);
        hm.put(runingSum,hm.getOrDefault(runingSum,0)+1);

        cnt+=pathSum2(root.left,runingSum,target,hm);
        cnt+=pathSum2(root.right,runingSum,target,hm);

        hm.put(runingSum,hm.get(runingSum)-1);
        return cnt;
    }



}
