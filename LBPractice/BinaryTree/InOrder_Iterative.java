package LoveBabbar.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder_Iterative {
    public class Pair{
        LevelOrderTraversal.TreeNode node;
        int state;
        Pair(LevelOrderTraversal.TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    public List<Integer> inorderTraversal(LevelOrderTraversal.TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        Stack<Pair> st = new Stack<>();

        st.push(new Pair(root,1));

        while(st.size()>0){
            Pair top = st.peek();
            if(top.state==1){
                top.state++;
                if(top.node.left!=null) st.push(new Pair(top.node.left,1));
            }else if(top.state == 2){
                top.state++;
                if(top.node.right!=null) st.push(new Pair(top.node.right,1));
            }else{
                lst.add(top.node.val);
                st.pop();
            }
        }
        return lst;
    }
}
