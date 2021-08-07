package LoveBabbar.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LeftView {
    public class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    // ye aese hi krna hai mera method bekaar hai niche dekhlo
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        if(root==null) return new ArrayList<>();
        ArrayList<Integer> lst = new ArrayList<>();
        leftView(root,lst,0);
        return lst;
    }
    void leftView(Node root,ArrayList<Integer> lst,int depth){
        if(root==null) return;

        if(lst.size()==depth){
            lst.add(root.data);
        }
        leftView(root.left,lst,depth+1);
        leftView(root.right,lst,depth+1);
    }
    ArrayList<Integer> leftView_mine(Node root)
    {
        // Your code here
        if(root==null) return new ArrayList<>();
        Queue<Node> q = new ArrayDeque<>();
        ArrayList<Integer> lst = new ArrayList<>();
        q.add(root);
        ArrayList<Integer> lst1 = new ArrayList<>();
        while(q.size()>0){
            int sizeofq = q.size();
            lst1 = new ArrayList<>();
            for(int i=0;i<sizeofq;i++){
                Node rem = q.remove();
                if(lst1.size()==0) lst1.add(rem.data);

                if(rem.left!=null) q.add(rem.left);
                if(rem.right!=null) q.add(rem.right);
            }
            lst.add(lst1.get(0));
        }
        return lst;
    }

}
