package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class LowestCommonAncestor {
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
        if (node.data == data) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.data);
            return path;
        }

        for (Node child : node.children) {
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size() > 0) {
                ptc.add(node.data);
                return ptc;
            }
        }

        return new ArrayList<>();
    }

    public static int lca(Node node, int d1, int d2) {
        // sir ka n m
        ArrayList<Integer> a1 = nodeToRootPath(node, d1);
        ArrayList<Integer> a2 = nodeToRootPath(node, d2);
        int i = a1.size() - 1;
        int j = a2.size() - 1;
        while (i >= 0 && j >= 0 && a1.get(i) == a2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return a1.get(i);


        // mera n2 m
        /*
        ArrayList<Integer> a1 = nodeToRootPath(node, d1);
        ArrayList<Integer> a2 = nodeToRootPath(node, d2);
        for (int i = 0; i < a1.size(); i++) {
            for (int j = 0; j < a2.size(); j++) {
                if (a1.get(i) == a2.get(j)) {
                    return a1.get(i);
                }
            }
        }
        return 0;
        */
    }
}
