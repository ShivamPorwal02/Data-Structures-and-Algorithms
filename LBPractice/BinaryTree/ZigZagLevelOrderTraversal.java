package LoveBabbar.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(LevelOrderTraversal.TreeNode root) {
        if(root==null) return new ArrayList<>();
        Stack<LevelOrderTraversal.TreeNode> st1 = new Stack<>();
        Stack<LevelOrderTraversal.TreeNode> st2 = new Stack<>();

        List<List<Integer>> lst = new ArrayList<>();

        st2.add(root);
        int cnt = 1;

        while(st2.size()>0 || st1.size()>0){
            ArrayList<Integer> lst1 = new ArrayList<>();
            if(st2.size()==0){
                while(st1.size()>0){

                    LevelOrderTraversal.TreeNode rem = st1.pop();
                    lst1.add(rem.val);
                    if(cnt%2==1){
                        if(rem.left!=null) st2.add(rem.left);
                        if(rem.right!=null) st2.add(rem.right);
                    }else{
                        if(rem.right!=null) st2.add(rem.right);
                        if(rem.left!=null) st2.add(rem.left);
                    }
                }
                cnt++;
            }else{
                while(st2.size()>0){

                    LevelOrderTraversal.TreeNode rem = st2.pop();
                    lst1.add(rem.val);
                    if(cnt%2==1){
                        if(rem.left!=null) st1.push(rem.left);
                        if(rem.right!=null) st1.push(rem.right);
                    }else{
                        if(rem.right!=null) st1.push(rem.right);
                        if(rem.left!=null) st1.push(rem.left);
                    }
                }
                cnt++;
            }
            lst.add(lst1);
        }
        return lst;
    }
}
