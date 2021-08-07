package LoveBabbar.BinaryTree;

public class LeafAtSameLevel {
    class Node{
        int data;
        Node left;
        Node right;
    }
    int depth;
    boolean check(Node root)
    {
        // Your code here
        depth = 0;
        return toCheck(root,0);

    }
    boolean toCheck(Node root,int dp){
        if(root==null){
            return true;
        }else if(root.left==null && root.right==null){
            if(depth==0){
                depth = dp;
                return true;
            }else if(depth==dp){
                return true;
            }else{
                return false;
            }
        }

        boolean left = toCheck(root.left,dp+1);
        boolean right = toCheck(root.right,dp+1);
        return left && right;
    }
}
