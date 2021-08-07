package LoveBabbar.BinaryTree;

public class BinaryTreeMaximumPathSum_LeetCode {

    // issm hmne same diameter ki trh kia hai ek baarkhud node sbb try krle ki rightSum m khud ko jod le leftsum m
    // khud o jod le aur left+right+val jod k dekhleta hoon sb krlia agr ni hota ax se jdya to return krdeta hai
    // max left right m se aur khudko
    static int maxSum;
    public int maxPathSum(LevelOrderTraversal.TreeNode root) {
        maxSum=root.val;
        maximumSum(root);
        return maxSum;
    }
    public int maximumSum(LevelOrderTraversal.TreeNode root){

        if(root==null) return 0;

        int left = maximumSum(root.left);
        int right = maximumSum(root.right);
        int leftSum = left+root.val;
        int rightSum = right+root.val;
        int sum = left+right+root.val;
        if(sum>maxSum) maxSum = sum;
        if(leftSum>maxSum) maxSum = leftSum;
        if(rightSum>maxSum) maxSum = rightSum;
        if(root.val>maxSum) maxSum = root.val;
        return Math.max(Math.max(leftSum,rightSum),root.val);
    }
}
