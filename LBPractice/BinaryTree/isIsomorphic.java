package LoveBabbar.BinaryTree;

public class isIsomorphic {
    class Node{
        int data;
        Node left,right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    boolean isIsomorphic(Node root1, Node root2)
    {
        // code here
        if(root1==null && root2==null) return true;

        if(root1==null || root2==null) return false;

        if(root1.data != root2.data) return false;
        return isIsomorphic(root1.left,root2.left) && isIsomorphic(root1.right,root2.right) ||
                isIsomorphic(root1.right,root2.left) && isIsomorphic(root1.left,root2.right);
    }
}
