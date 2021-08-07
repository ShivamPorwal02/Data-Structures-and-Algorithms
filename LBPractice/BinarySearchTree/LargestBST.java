package LoveBabbar.BinarySearchTree;

public class LargestBST {
    class Node{
        int data;
        Node left;
        Node right;
    }
    static class Pair{
        int min;
        int max;
        int height;
        boolean isBST;
        Pair(){

        }
        Pair(int min, int max, int height,boolean isBST){
            this.min = min;
            this.max = max;
            this.height = height;
            this.isBST = isBST;

        }
    }
    static int largestBst(Node root)
    {
        // Write your code here
        Pair ans = largestBST(root);
        return ans.height;

    }
    static Pair largestBST(Node root){
        if(root==null){
            Pair bp =  new Pair(Integer.MAX_VALUE,Integer.MIN_VALUE,0,true);
            return bp;
        }

        Pair left = largestBST(root.left);
        Pair right = largestBST(root.right);

        Pair mp = new Pair();

        mp.isBST = left.isBST && right.isBST && (root.data>left.max && root.data<right.min);

        mp.min = Math.min(Math.min(left.min,right.min),root.data);
        mp.max = Math.max(Math.max(left.max,right.max),root.data);

        if(mp.isBST==true){
            mp.height = left.height + right.height + 1;
        }else{
            mp.height = Math.max(left.height,right.height);
        }
        return mp;
    }
}
