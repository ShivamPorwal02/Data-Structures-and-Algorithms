package LoveBabbar.BinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;

public class BinaryTreetoBST {
    class Node{
        int data;
        Node left;
        Node right;
    }
    ArrayList<Integer> lst;
    int i ;
    Node binaryTreeToBST(Node root)
    {
        // Your code here
        i=0;
        lst = new ArrayList<>();
        inorder(root);
        Collections.sort(lst);
        //   System.out.println(lst);
        convertBST(root);
        return root;
    }

    void inorder(Node root){
        if(root==null) return;

        inorder(root.left);
        lst.add(root.data);
        inorder(root.right);
        return;
    }

    void convertBST(Node root){
        if(root==null) return ;

        // i++;
        convertBST(root.left);
        if(root.data!=lst.get(i)){
            root.data = lst.get(i);
        }
        i++;
        convertBST(root.right);
    }
}
