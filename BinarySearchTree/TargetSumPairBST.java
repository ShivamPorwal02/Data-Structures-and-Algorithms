package BinarySearchTree;

import java.util.ArrayList;
import java.util.Stack;

public class TargetSumPairBST {
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
    static ArrayList<Integer> f = new ArrayList<>();
    public static void inorder(Node node){
        //   ArrayList<Integer> f = new ArrayList<>();
        if(node==null){
            return;
        }
        inorder(node.left);
        f.add(node.data);
        inorder(node.right);
    }
    public static void tsp(Node node,int tar){
        inorder(node);
        int i=0;
        // System.out.println(f);
        int j = f.size()-1;
        while(i<j){
            if(f.get(i)+f.get(j)==tar){
                System.out.println(f.get(i)+" "+f.get(j));
                i++;
                j--;
            }else if(f.get(i)+f.get(j)>tar){
                j--;
            }else{
                i++;
            }

        }
    }
    public static boolean find(Node node,int data){
        if(node==null){
            return false;
        }
        if(node.data>data){
            return find(node.left,data);
        }else if(node.data<data){
            return find(node.right,data);
        }else{
            return true;
        }
    }
    public static void tsp2(Node root,Node node,int tar){
        if(node==null){
            return;
        }
        tsp2(root,node.left,tar);
        int comp = tar - node.data;
        if(node.data<comp){
            if(find(root,comp)==true){
                System.out.println(node.data+" "+comp);
            }
        }
        tsp2(root,node.right,tar);
    }
    public static class ITPair{
        Node node;
        int state =0;
        ITPair(Node node,int state){
            this.node = node;
            this.state = state;
        }
    }
    public static void bestappraoch(Node node,int tar){
        Stack<ITPair> ls = new Stack<>();
        Stack<ITPair> rs = new Stack<>();

        ls.push(new ITPair(node,0));
        rs.push(new ITPair(node,0));

        Node left = getNextFromNormalInorder(ls);
        Node right = getNextFromReverseInorder(rs);

        while(left.data<right.data){
            if(left.data+right.data<tar){
                left = getNextFromNormalInorder(ls);
            }else if(left.data+right.data>tar){
                right = getNextFromReverseInorder(rs);
            }else{
                System.out.println(left.data+" "+right.data);
                left = getNextFromNormalInorder(ls);
                right = getNextFromReverseInorder(rs);
            }
        }
    }
    public static Node getNextFromNormalInorder(Stack<ITPair> st){
        while(st.size()>0){
            ITPair p = st.peek();
            if(p.state==0){
                if(p.node.left!=null){
                    st.push(new ITPair(p.node.left,0));
                }
                p.state++;
            }else if(p.state==1){
                if(p.node.right!=null){
                    st.push(new ITPair(p.node.right,0));
                }
                p.state++;
                return p.node;
            }else{
                st.pop();
            }
        }
        return null;
    }
    public static Node getNextFromReverseInorder(Stack<ITPair> st){
        while(st.size()>0){
            ITPair p = st.peek();
            if(p.state==0){
                if(p.node.right!=null){
                    st.push(new ITPair(p.node.right,0));
                }
                p.state++;
            }else if(p.state==1){
                if(p.node.left!=null){
                    st.push(new ITPair(p.node.left,0));
                }
                p.state++;
                return p.node;
            }else{
                st.pop();
            }
        }
        return null;
    }
}
