package LoveBabbar.Heap;

import java.util.LinkedList;
import java.util.Queue;

public class isBinaryTreeHeap {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    boolean isHeap(Node root)
    {
        return isComplete(root) && isItHeap(root);
    }
    boolean isComplete(Node root){
        boolean end = false;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.size()>0){
            Node temp = q.remove();
            if(temp==null) end = true;
            else{
                if(end) return false;
                else{
                    q.add(temp.left);
                    q.add(temp.right);
                }
            }
        }
        return true;
    }
    boolean isItHeap(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(q.size()>0){
            Node temp = q.remove();
            if(temp.left!=null){
                if(temp.data<temp.left.data) return false;
                else{
                    q.add(temp.left);
                }
            }
            if(temp.right!=null){
                if(temp.data<temp.right.data) return false;
                else{
                    q.add(temp.right);
                }
            }
        }
        return true;
    }
}
