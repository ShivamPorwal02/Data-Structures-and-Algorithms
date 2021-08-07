package LoveBabbar.BinarySearchTree;

public class kthSmallestinBST {
    class Node{
        int data;
        Node left;
        Node right;
    }
    int i;
    int a;
    // Return the Kth smallest element in the given BST
    public int KthSmallestElement(Node root, int k)
    {
        // Write your code here
        i=1;
        a=-1;
        return kth(root,k);

    }
    public int kth(Node root,int k){
        if(root==null) return -1;

        kth(root.left,k);
        if(i==k && a==-1){
            a = root.data;
            return a;
        }
        i++;
        kth(root.right,k);
        return a;
    }
}
