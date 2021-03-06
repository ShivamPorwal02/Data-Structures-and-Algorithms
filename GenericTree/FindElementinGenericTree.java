package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class FindElementinGenericTree {
    private static class Node {
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

    public static boolean find(Node node, int data) {
//        boolean x = false;
//        for(Node child:node.children){
//            x = find(child,data);
//            if(x==true){
//                return true;
//            }
//        }
//        if(node.data==data){
//            return true;
//        }else{
//            return false;
//        }

        if (node.data == data) {
            return true;
        }
        for (Node child : node.children) {
            boolean x = find(child, data);
            if (x == true) {
                return true;
            }
        }
        return false;
    }
}
