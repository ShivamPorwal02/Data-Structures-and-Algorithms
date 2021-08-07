package LoveBabbar.BinaryTree;

import BinarySearchTree.LCAofBST;

public class MinimumDistanceBetweenTwoNodes {

    class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    int findDist(Node root, int a, int b) {

        Node lca = lca(root,a,b);
        return level(lca,a,0)+level(lca,b,0);
    }
    public Node lca(Node root,int a,int b){
        if(root==null || root.data==a || root.data==b) return root;

        Node left = lca(root.left,a,b);
        Node right = lca(root.right,a,b);
        if(left==null) return right;
        else if(right==null) return left;
        return root;
    }
    public int level(Node root,int a,int level){
        if(root==null) return -1;
        if(root.data==a){
            return level;
        }
        int left = level(root.left,a,level+1);
        if(left==-1){
            return level(root.right,a,level+1);
        }
        return left;
    }
}
