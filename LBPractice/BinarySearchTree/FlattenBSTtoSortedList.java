package LoveBabbar.BinarySearchTree;

public class FlattenBSTtoSortedList {
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public Node flatten(Node root){
        Node dummy = new Node(-1);
        Node prev = dummy;
        inorder(root,prev);

        prev.left = null;
        prev.right = null;

        return dummy.right;
    }
    public void inorder(Node root,Node prev){
        if(root == null) return;

        inorder(root.left,prev);
        prev.left = null;
        prev.right = root;
        prev = root;
        inorder(root.right,prev);
    }
}
