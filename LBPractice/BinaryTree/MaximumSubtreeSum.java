package LoveBabbar.BinaryTree;

public class MaximumSubtreeSum {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right) {
            this.data = data;
            this.left = left;
            this.right = left;
        }
    }
    int maxSum;
    Node maxSumNode;
    public int maxSubtreeSum(Node root){
        maxSum = 0;
        maxSum(root);
        return maxSum;
    }
    public int maxSum(Node root){
        if(root==null) return 0;
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        int sum = left+right+root.data;
        if(sum>maxSum){
            maxSum = 0;
            maxSumNode = root;
        }
        return sum;
    }
}
