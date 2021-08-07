package GenericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLinewiseDifferentApproach {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(){

        }
        Node(int data){
            this.data = data;
        }
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

    public static int max(Node node) {
        int m = Integer.MIN_VALUE;

        for (Node child : node.children) {
            int cm = max(child);
            m = Math.max(m, cm);
        }
        m = Math.max(m, node.data);

        return m;
    }

    public static int height(Node node) {
        int h = -1;

        for (Node child : node.children) {
            int ch = height(child);
            h = Math.max(h, ch);
        }
        h += 1;

        return h;
    }

    public static void traversals(Node node){
        System.out.println("Node Pre " + node.data);

        for(Node child: node.children){
            System.out.println("Edge Pre " + node.data + "--" + child.data);
            traversals(child);
            System.out.println("Edge Post " + node.data + "--" + child.data);
        }

        System.out.println("Node Post " + node.data);
    }
    public static void Approach2(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        q.add(new Node(-1));
        while(q.size()>0){
            Node d = q.remove();
            if(d.data != -1){
                System.out.print(d.data+" ");
                for(Node child:d.children){
                    q.add(child);
                }
            }else{
                if(q.size()>0){
                    q.add(new Node(-1));
                    System.out.println();
                }

            }
        }
    }
    public static void Approach3(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size()>0){
            int cs = q.size();
            for(int i=0;i<cs;i++){
                Node d = q.remove();
                System.out.print(d.data+" ");
                for(Node child:d.children){
                    q.add(child);
                }
            }
            System.out.println();
        }
    }
    private static class Pair{
        Node node;
        int level;
        Pair(Node node,int level){
            this.node = node;
            this.level = level;
        }
    }

    public static void Approach4(Node node){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(node,1));
        int level = 1;
        while (q.size()>0){
            Pair p = q.remove();
            if(p.level>level){
                level++;
                System.out.println();
            }
            System.out.print(p.node.data+" ");
            for(Node child:p.node.children){
                q.add(new Pair(child,p.level+1));
            }
        }
    }
}
