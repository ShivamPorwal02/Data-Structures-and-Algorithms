package BinarySearchTree;

import java.util.Stack;

public class PrintinRange {
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

    public static void pir(Node node, int d1, int d2) {
        // issm pura tree visit hora hai
        // method1
        if(node==null){
            return;
        }
        pir(node.left,d1,d2);
        if(node.data>=d1 && node.data<=d2){
            System.out.println(node.data);
        }
        pir(node.right,d1,d2);

        // method 2
        if(node==null){
            return;
        }
        if(d1<node.data && d2<node.data){
            pir(node.left,d1,d2); // agr vo hi element tumse bda hai to usk right m to aur bde honge to rt m jaane
                                  // fyda ni
        }else if(d1>node.data && d2>node.data){
            pir(node.right,d1,d2);// agr vo hi element tumse chota hai to usk left m to aur chote honge to left m jaane
                                  // fyda ni
        }
        else{
            pir(node.left,d1,d2);
            System.out.println(node.data); // kyuki increasing m print krna hai mtln INORDER in BST
            // islia hm beech m print krdete hai
            pir(node.right,d1,d2);
        }
    }
}
