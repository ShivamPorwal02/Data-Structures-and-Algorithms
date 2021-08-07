package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class NodeToRootPath {
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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data) {
 /*       ArrayList<Integer> ans = new ArrayList<>();
        if (node.data == data) {
            ans.add(node.data);
            return ans;
        }
        for (Node child : node.children) {
            ans = nodeToRootPath(child, data);
            if (ans.size() > 0) {
                ans.add(node.data);
                return ans;
            }
        }
        return ans;
*/
        // method 2 (sir waala)

        if (node.data == data) {
            ArrayList<Integer> an = new ArrayList<>();
            an.add(node.data);
            return an;
        }
        for (Node child : node.children) {
            ArrayList<Integer> x = nodeToRootPath(child, data);
            if (x.size() > 0) {
                x.add(node.data);
                return x;
            }
        }
        return new ArrayList<>();
    }
}
