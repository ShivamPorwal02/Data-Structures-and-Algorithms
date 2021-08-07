package LoveBabbar.BinaryTree;

public class isBinaryTreeSumTreeorNot {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    class Pair{
        int sum;
        boolean isSum;
        Pair(int sum,boolean isSum){
            this.sum = sum;
            this.isSum = isSum;
        }
    }
    boolean isSumTree(Node root)
    {
        // Your code here
        Pair res = sum(root);

        return res.isSum;


    }
    Pair sum(Node root){
        if(root==null) return new Pair(0,true);
        else if(root.left==null && root.right==null) return new Pair(root.data,true);

        Pair left = sum(root.left);
        Pair right = sum(root.right);

        if(left.sum+right.sum!=root.data) return new Pair(left.sum+right.sum+root.data,false);
        else return new Pair(left.sum+right.sum+root.data,left.isSum&&right.isSum);
    }
}
