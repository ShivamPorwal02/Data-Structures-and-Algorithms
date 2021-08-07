package LoveBabbar.BinaryTree;

public class ConstructBinaryTreeFromPreorderandInorderTraversal {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static int idx;
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // code here
        idx = 0;
        Node root = Tree(inorder,preorder,0,inorder.length-1);
        return root;
    }
    public static  Node Tree(int[] inorder,int[] preorder,int start,int end){
        if(start>end) return null;

        int curr = preorder[idx];
        idx++;

        Node node = new Node(curr);
        int pos = search(inorder,curr,start,end);

        if(start==end) return node;

        node.left = Tree(inorder,preorder,start,pos-1);
        node.right = Tree(inorder,preorder,pos+1,end);
        return node;
    }
    public static int search(int[] inorder,int curr,int start,int end){
        for(int i=start;i<=end;i++){
            if(inorder[i]==curr) return i;
        }
        return -1;
    }
}
