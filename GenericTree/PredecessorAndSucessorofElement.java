package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class PredecessorAndSucessorofElement {
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

    static Node predecessor;
    static Node successor;
    static int state = 0;
    public static void predecessorAndSuccessor(Node node, int data) {
        if(state==0){
            if(node.data==data){
                state = 1;
            }else{
                predecessor = node;
            }
        }else if(state==1){
            successor = node;
            state=2;
        }
        for(Node child:node.children){
            predecessorAndSuccessor(child,data);
        }
    }
}
