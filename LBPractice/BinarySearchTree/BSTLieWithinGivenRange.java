package LoveBabbar.BinarySearchTree;

public class BSTLieWithinGivenRange {
    class Node{
        int data;
        Node left;
        Node right;
    }
    int cnt;
    int getCount(Node root,int l, int h)
    {
        //Your code here
        cnt = 0;
        return count(root,l,h);
    }
    int count(Node root,int l,int m){
        if(root == null) return cnt;

        if(root.data>=l && root.data<=m){
            cnt++;
            count(root.left,l,m);
            count(root.right,l,m);
        }
        if(root.data<l){
            count(root.right,l,m);
        }else if(root.data > m){
            count(root.left,l,m);
        }
        return cnt;
    }
}
