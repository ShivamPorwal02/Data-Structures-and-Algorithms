package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumInGenericTree {
    public static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;

        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) {
                st.pop();
            } else {
                Node t = new Node();
                t.data = arr[i];

                if (st.size() > 0) {
                    st.peek().children.add(t);
                } else {
                    root = t;
                }

                st.push(t);
            }
        }

        return root;
    }

    public static int size(Node node) {
        int s = 0;

        for (Node child : node.children) {
            s += size(child);
        }
        s += 1;

        return s;
    }
    static int max = Integer.MIN_VALUE;
    public static int max(Node node) {
//        for (Node child:node.children ) {
//            int x = max(child);
//            if(node.data>max){
//                max = node.data;
//            }
//        }
//        return max;
        int max = Integer.MIN_VALUE;
        for(Node child:node.children){
            int cm = max(child);
            max = Math.max(cm,max);
        }
        max = Math.max(max,node.data);
        return max;
    }

}
