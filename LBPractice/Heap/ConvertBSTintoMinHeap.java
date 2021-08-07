package LoveBabbar.Heap;

import java.util.ArrayList;

public class ConvertBSTintoMinHeap {
    static class Node{

        // ek cheez yaad rkhna issm ki hme complete binary tree dia hua hai qn m islia ese krdia
        int data;
        Node left,right;

        // Constructor
        Node(){
            this.data = 0;
            this.left = this.right = null;
        }

        Node(int data)
        {
            this.data = data;
            this.left = this.right = null;

        }
    }
    static void convertToMinHeap(Node root){
        ArrayList<Integer> lst = new ArrayList<>();
        inorder(root,lst);
        preorder(root,lst,0);
    }
    static void inorder(Node root, ArrayList<Integer> lst){
        if(root==null) return;
        inorder(root.left,lst);
        lst.add(root.data);
        inorder(root.right,lst);
    }
    static void preorder(Node root,ArrayList<Integer> lst,int i){
        if(root==null) return;

        root.data = lst.get(i);
        preorder(root.left,lst,i+1);
        preorder(root.right,lst,i+1);
    }
}
