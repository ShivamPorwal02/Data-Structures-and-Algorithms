package BinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class LCAofBST {
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
    public static ArrayList<Integer> nodeToRoot(Node node,int data){
        if(node==null){
            return new ArrayList<>();
        }
        if(node.data>data){
            ArrayList<Integer> a = nodeToRoot(node.left,data);
            if(a.size()>0){
                a.add(node.data);
                return a;
            }
        }else if(node.data<data){
            ArrayList<Integer> a = nodeToRoot(node.right,data);
            if(a.size()>0){
                a.add(node.data);
                return a;
            }
        }else{
            ArrayList<Integer> x = new ArrayList<>();
            x.add(node.data);
            return x;
        }
        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        if(node.data>d1 && node.data>d2){
            return lca(node.left,d1,d2);
        }else if(node.data<d1 && node.data<d2) {
            return lca(node.right, d1, d2);
        }else {
            return node.data;
        }







        // MY METHOD
//        ArrayList<Integer> a1 = nodeToRoot(node,d1);
//        ArrayList<Integer> a2 = nodeToRoot(node,d2);
//        int i=a1.size()-1;
//        int j=a2.size()-1;
//        // System.out.println(a1);
//        // System.out.println(a2);
//        while(i>=0 && j>=0 && a1.get(i)==a2.get(j)){
//            i--;
//            j--;
//        }
//        return a1.get(i+1);
    }
}
