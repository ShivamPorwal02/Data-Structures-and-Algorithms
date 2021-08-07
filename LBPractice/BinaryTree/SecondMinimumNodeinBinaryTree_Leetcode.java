package LoveBabbar.BinaryTree;

public class SecondMinimumNodeinBinaryTree_Leetcode {
    public int findSecondMinimumValue(LevelOrderTraversal.TreeNode root) {

        // iska explaination leetcode k notes m hai
        if(root==null) return -1;
        if(root.left==null && root.right==null) return -1;

        int left = root.left.val;
        int right = root.right.val;
        if(root.val==left){
            left = findSecondMinimumValue(root.left);
        }
        if(root.val == right){
            right = findSecondMinimumValue(root.right);
        }

        if(left!=-1 && right!=-1){
            return Math.min(left,right);
        }else if(left!=-1){
            return left;
        }else{
            return right;
        }

    }
}
