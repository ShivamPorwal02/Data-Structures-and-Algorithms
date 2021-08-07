package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintNodesKDistanceAway {
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
    public static ArrayList<Node> nodeToRootPath(Node node, int data){
        if(node==null){
            return new ArrayList<>();
        }
        if(node.data==data){
            ArrayList<Node> a = new ArrayList<>();
            a.add(node);
            return a;
        }
        ArrayList<Node> x = nodeToRootPath(node.left,data);
        if(x.size()>0){
            x.add(node);
            return x;
        }

        ArrayList<Node> s = nodeToRootPath(node.right,data);
        if(s.size()>0){
            s.add(node);
            return s;
        }
        return new ArrayList<>();
    }
    public static void printKLevelsDown(Node node, int k,Node blocker){
        if(node==null || k<0 || node==blocker){
            return;
        }
        if(k==0){
            System.out.println(node.data);
        }
        printKLevelsDown(node.left,k-1,blocker);
        printKLevelsDown(node.right,k-1,blocker);
    }

    public static void printKNodesFar(Node node, int data, int k) {
        ArrayList<Node> cs = nodeToRootPath(node,data);
        for(int i=0;i<cs.size();i++){
            printKLevelsDown(cs.get(i),k-i,i==0?null:cs.get(i-1));
        }

    }
}
