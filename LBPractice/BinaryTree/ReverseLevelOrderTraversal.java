package LoveBabbar.BinaryTree;

import java.util.*;

public class ReverseLevelOrderTraversal {
    public class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public ArrayList<Integer> reverseLevelOrder(Node node) {
        // code here
        Queue<Node> q = new ArrayDeque<>();
        Stack<Integer> st = new Stack<>();

        q.add(node);
        ArrayList<Integer> lst = new ArrayList<>();

        while (q.size() > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node rem = q.remove();
                st.push(rem.data);

                if (rem.right != null) q.add(rem.right);
                if (rem.left != null) q.add(rem.left);
            }
        }
        while (st.size() > 0) {
            lst.add(st.pop());
        }
        return lst;
    }
    // ek leetcode version hai


    // ye mera hai
    public List<List<Integer>> levelOrderBottom(LevelOrderTraversal.TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<LevelOrderTraversal.TreeNode> q = new ArrayDeque<>();
        Stack<Integer> q1 = new Stack<>();
        List<List<Integer>> lst = new ArrayList<>();
        ArrayList<Integer> lst1 = new ArrayList<>();
        q.add(root);
        while (q.size() > 0) {
            int sizeofq = q.size();
            for (int i = 0; i < sizeofq; i++) {
                LevelOrderTraversal.TreeNode rem = q.remove();
                q1.add(rem.val);
                if (rem.right != null) q.add(rem.right);
                if (rem.left != null) q.add(rem.left);
            }
            q1.add(Integer.MAX_VALUE);
        }

        while (q1.size() > 0) {
            Integer temp = q1.pop();
            if (temp != Integer.MAX_VALUE) lst1.add(temp);
            else {
                if (lst1.size() > 0) lst.add(lst1);
                lst1 = new ArrayList<>();
            }
        }
        lst.add(lst1);
        return lst;
    }
    public List<List<Integer>> levelOrderBottom_method2(LevelOrderTraversal.TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<LevelOrderTraversal.TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                LevelOrderTraversal.TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(0,list);
        }
        return result;
    }
}
