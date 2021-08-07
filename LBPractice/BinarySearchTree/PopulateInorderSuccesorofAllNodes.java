package LoveBabbar.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class PopulateInorderSuccesorofAllNodes {
    class Node{
        int data;
        Node left;
        Node right;
        Node next;
    }
    public static void populateNext(Node root)
    {
        Queue<Node> queue = new LinkedList<>();
        inOrderTraversal(root,queue);

        while(!queue.isEmpty()){
            Node temp = queue.poll();
            temp.next = queue.peek();
        }
    }

    public static void inOrderTraversal(Node root,Queue<Node> queue)
    {
        if(root == null)
            return;

        inOrderTraversal(root.left,queue);
        queue.offer(root);
        inOrderTraversal(root.right,queue);
    }

    /// method 2


}
