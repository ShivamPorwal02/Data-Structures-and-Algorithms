package LoveBabbar.BinaryTree;

import java.util.ArrayList;

public class BoundaryTraversalofBinaryTree {
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
    ArrayList <Integer> printBoundary(Node root)
    {
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(root.data);

        LeftSide(root.left,lst);
        leafnode(root.left,lst);
        leafnode(root.right,lst);
        RightSide(root.right,lst);
        return lst;
    }

    void LeftSide(Node root,ArrayList<Integer> lst){
        if(root==null) return;

        if(root.left!=null){
            lst.add(root.data);
            LeftSide(root.left,lst);
        }else if(root.right!=null){
            lst.add(root.data);
            LeftSide(root.right,lst);
        }
    }
    void RightSide(Node root, ArrayList<Integer> lst){
        if(root==null) return;

        if(root.right!=null){
            RightSide(root.right,lst);
            lst.add(root.data);
        }else if(root.left!=null){
            RightSide(root.left,lst);
            lst.add(root.data);
        }
    }

    void leafnode(Node root,ArrayList<Integer> lst){
        if(root==null) return;

        leafnode(root.left,lst);
        if(root.left==null && root.right==null) lst.add(root.data);
        leafnode(root.right,lst);

    }
}
