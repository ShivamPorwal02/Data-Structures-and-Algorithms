package LoveBabbar.BinaryTree;

import java.util.ArrayList;

public class KthAncestorinBinaryTree {
    class Node{
        int data;
        Node left,right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    ArrayList<Integer> lst;
    public int kthAncestor(Node root, int k, int node)
    {
        //Write your code here
        lst = new ArrayList<>();
        allAncestor(root,node);
        if(k>lst.size()) return -1;
        else return lst.get(k-1);
        // return 1;
    }
    public int allAncestor(Node root,int target){
        if(root!=null){
            if(root.data==target){
                return 1;
            }
            if(allAncestor(root.left,target)==1 || allAncestor(root.right,target)==1){
                lst.add(root.data);
                return 1;
            }

        }
        return 0;
    }
}
