package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class DiameterOfGenericTree {
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

    public static ArrayList<Integer> nodeToRootPath(Node node, int data){
        if(node.data == data){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(node.data);
            return ans;
        }
        for(Node child:node.children){
            ArrayList<Integer> b= nodeToRootPath(child,data);
            if(b.size()>0){
                b.add(node.data);
                return b;
            }
        }
        return new ArrayList<>();
    }
    static int dia= 0;
    public static int diameter(Node node){
        int dh = -1;
        int sdh = -1;
        for(Node child:node.children){
            int ch = diameter(child);
            if(ch>dh){
                sdh = dh;
                dh = ch;
            }else if(ch>sdh){
                sdh = ch;
            }
        }
        int cand = dh+sdh+2;
        if(cand>dia){
            dia = cand;
        }
        dh+=1;
        return dh;
    }
}
