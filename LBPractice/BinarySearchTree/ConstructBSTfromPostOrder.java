package LoveBabbar.BinarySearchTree;

public class ConstructBSTfromPostOrder {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    static int idx;
    public static Node constructTree(int postorder[],int n)
    {
        //Add your code here.   // code here
        idx = postorder.length-1;
        return bstInorder(postorder,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static Node bstInorder(int[] preorder,long min,long max){
        if(idx<0 || preorder[idx] <= min || preorder[idx] >=max){
            return null;
        }

        Node node = new Node(preorder[idx]);
        idx--;

        node.right = bstInorder(preorder,node.data,max);
        node.left = bstInorder(preorder,min,node.data);
        return node;
    }
}
