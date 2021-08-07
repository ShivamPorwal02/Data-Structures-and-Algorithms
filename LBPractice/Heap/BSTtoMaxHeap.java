package LoveBabbar.Heap;

import java.util.ArrayList;

public class BSTtoMaxHeap {
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
    static int i;
    public static void convertToMaxHeapUtil(Node root)
    {
        //code here
        i=0;
        ArrayList<Integer> a=new ArrayList<>();
        inorder(root,a);
        postorder(root,a);
    }
    public static void inorder(Node root,ArrayList<Integer> a){
        if(root == null)
            return;
        inorder(root.left,a);
        a.add(root.data);
        inorder(root.right,a);
    }
    public static void postorder(Node root,ArrayList<Integer> a){
        if(root == null )
            return;
        postorder(root.left,a);
        postorder(root.right,a);
        root.data=a.get(i);
        i++;
    }
}
