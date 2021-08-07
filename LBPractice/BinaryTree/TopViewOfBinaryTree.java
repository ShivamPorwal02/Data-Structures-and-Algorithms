package LoveBabbar.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class TopViewOfBinaryTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }

    }
    static class Pair{
        Node node;
        int level;
        Pair(Node node,int level){
            this.node = node;
            this.level = level;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> lst = new ArrayList<>();
        if(root==null) return lst;

        int[] widthh = new int[2];

        width(root,0,widthh);

        int len = widthh[1]-widthh[0]+1;

        Integer[] arr = new Integer[len];
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root,Math.abs(widthh[0])));

        while(q.size()>0){
            Pair rem = q.remove();
            int lvl = rem.level;

            if(arr[lvl]==null) arr[lvl] =rem.node.data;

            if(rem.node.left!=null) q.add(new Pair(rem.node.left,lvl-1));
            if(rem.node.right!=null) q.add(new Pair(rem.node.right,lvl+1));
        }

        for(Integer i : arr){
            lst.add(i);
        }
        return lst;
    }
    static void width(Node root,int lvl,int[] ans){
        if(root==null) return;

        ans[0] = Math.min(ans[0],lvl);
        ans[1] = Math.max(ans[1],lvl);

        width(root.left,lvl-1,ans);
        width(root.right,lvl+1,ans);
    }
}
