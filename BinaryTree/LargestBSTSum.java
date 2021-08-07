package BinaryTree;

import java.util.Stack;

public class LargestBSTSum {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static class Pair {
        Node node;
        int state;

        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node construct(Integer[] arr) {
        Node root = new Node(arr[0], null, null);
        Pair rtp = new Pair(root, 1);

        Stack<Pair> st = new Stack<>();
        st.push(rtp);

        int idx = 0;
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                idx++;
                if (arr[idx] != null) {
                    top.node.left = new Node(arr[idx], null, null);
                    Pair lp = new Pair(top.node.left, 1);
                    st.push(lp);
                } else {
                    top.node.left = null;
                }

                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (arr[idx] != null) {
                    top.node.right = new Node(arr[idx], null, null);
                    Pair rp = new Pair(top.node.right, 1);
                    st.push(rp);
                } else {
                    top.node.right = null;
                }

                top.state++;
            } else {
                st.pop();
            }
        }

        return root;
    }

    public static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    public static class MaxMinPair{
        boolean isBST;
        int min;
        int max;
        int nodes;
        Node node;
    }
    // bss BST ko chng krdia hai //
    public static MaxMinPair isBST(Node node){
        if(node==null){
            MaxMinPair p = new MaxMinPair();
            p.isBST = true;
            p.min = Integer.MAX_VALUE;
            p.max = Integer.MIN_VALUE;
            p.nodes = 0;
            p.node = null;
            return p;
        }
        MaxMinPair lc = isBST(node.left);
        MaxMinPair rc = isBST(node.right);

        MaxMinPair mp = new MaxMinPair();
        mp.isBST = lc.isBST && rc.isBST && (node.data>=lc.max && node.data<=rc.min);
        mp.max = Math.max(node.data,Math.max(lc.max,rc.max));
        mp.min = Math.min(node.data,Math.min(lc.min,rc.min));
        if(mp.isBST){
            mp.node = node;
            mp.nodes = lc.nodes+rc.nodes+1;
        }else if(lc.nodes>rc.nodes){
            mp.node = lc.node;
            mp.nodes = lc.nodes;
        }else{
            mp.node = rc.node;
            mp.nodes = rc.nodes;
        }
        return mp;
    }
}
