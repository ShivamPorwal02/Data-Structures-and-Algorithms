package LoveBabbar.BinarySearchTree;

import java.util.ArrayList;

public class BalanceBinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    ArrayList<Integer> lst;
    Node buildBalancedTree(Node root)
    {
        //Add your code here.
        if(root.left==null && root.right==null) return root;
        lst = new ArrayList<>();
        getSortedList(root);
        return BST(lst,0,lst.size()-1);
    }
    public void getSortedList(Node root) {
        if (root == null)
            return;

        getSortedList(root.left);
        lst.add(root.data);
        getSortedList(root.right);
    }
    public Node BST(ArrayList<Integer> lst, int start, int end){
        if(start>end) return null;

        int mid = (start+end)/2;
        Node node = new Node(lst.get(mid));

        node.left = BST(lst,start,mid-1);
        node.right = BST(lst,mid+1,end);

        return node;
    }
}
