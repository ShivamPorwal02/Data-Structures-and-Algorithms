package LoveBabbar.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class DiagonalTraversalofBinaryTree {
    public ArrayList<ArrayList<Integer>> diagonalTraversal(LevelOrderTraversal.TreeNode root){
        Queue<LevelOrderTraversal.TreeNode> q = new ArrayDeque<>();
        q.add(root);

        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();

        while(q.size()>0){
            int size = q.size();
            ArrayList<Integer> lst1 = new ArrayList<>();
            for(int i=0;i<size;i++){
                LevelOrderTraversal.TreeNode rem = q.remove();
                while(rem!=null){
                    lst1.add(rem.val);
                    if(rem.left!=null) q.add(rem.left);
                    rem = rem.right;
                }
            }
            lst.add(lst1);
        }
        return lst;
    }
}
