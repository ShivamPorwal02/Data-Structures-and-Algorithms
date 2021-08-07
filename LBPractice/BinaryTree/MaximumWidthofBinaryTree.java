package LoveBabbar.BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MaximumWidthofBinaryTree {
    public class Pair{
        LevelOrderTraversal.TreeNode node;
        int index;
        Pair(LevelOrderTraversal.TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(LevelOrderTraversal.TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root,0));
        int maxWidth = 0;
        while(q.size()>0){
            int size = q.size();
            int first = q.peek().index;
            int curr = 0;
            for(int i=0;i<size;i++){
                Pair rem = q.remove();
                curr = rem.index;
                if(rem.node.left!=null) q.add(new Pair(rem.node.left,2*curr));
                if(rem.node.right!=null) q.add(new Pair(rem.node.right,2*curr+1));
            }
            maxWidth = Math.max(maxWidth,curr-first+1);
        }
        return maxWidth;
    }
}
