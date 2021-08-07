package LoveBabbar.BinaryTree;

public class PathSum_LeetCode {

    // mera method
    public boolean hasPathSum(LevelOrderTraversal.TreeNode root, int targetSum) {
        if(root==null) return false;
        if(root.left==null && root.right==null){
            return root.val==targetSum ? true : false;
        }
        return sum(root,root,targetSum,0);
    }
    public boolean sum(LevelOrderTraversal.TreeNode main, LevelOrderTraversal.TreeNode root, int target, int sum){
        if(root==null) return false;

        sum= sum +root.val;

        boolean left = sum(root,root.left,target,sum);
        boolean right = sum(root,root.right,target,sum);

        if(sum==target && main!=root && root.left==null && root.right==null) return true; // leaf node bhi hona chahia


        return left || right;
    }
    // method 2 ; subtract krk

    public boolean hasPathSum_(LevelOrderTraversal.TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null && sum - root.val == 0) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
