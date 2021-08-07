package LoveBabbar.BinarySearchTree;

public class LCAinBST {
    class Node{
        int data;
        Node left;
        Node right;
    }
    Node LCA(Node root, int n1, int n2)
    {
        // code here.
        return lca(root,n1,n2);

    }

    Node lca(Node root,int n1,int n2){
        if(root==null ) return null;

        if(root.data>n1 && root.data>n2){
            return lca(root.left,n1,n2);
        }else if(root.data<n1 && root.data<n2){
            return lca(root.right,n1,n2);
        }
        return root;
    }
}
