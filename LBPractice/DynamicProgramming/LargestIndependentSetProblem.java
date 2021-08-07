package LoveBabbar.DynamicProgramming;

public class LargestIndependentSetProblem {
    class Node {
        int data;
        Node left, right;

        public Node(int data){
            this.data = data;
        }
    }
    public int LISS(Node node){
        //Write your code here

        if(node==null) return 0;

        int lft = LISS(node.left);
        int rgt = LISS(node.right);

        int size_incl = 1;
        if (node.left!=null)
            size_incl += LISS(node.left.left) +
                    LISS(node.left.right);
        if (node.right!=null)
            size_incl += LISS(node.right.left) +
                    LISS(node.right.right);

        return Math.max(lft+rgt,size_incl);
    }

    // isko hm hashmap node aur int ka bna k save krk bhi krr skte hai

}
