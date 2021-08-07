package LoveBabbar.BinaryTree;

import java.util.*;

public class VerticalOrderTraversal_GFG {
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
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }

    static ArrayList <Integer> verticalOrder(Node root)
    {
        // add your code here
        Queue<Pair> q  = new ArrayDeque<>();
        q.add(new Pair(root,0));

        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int maxLvl = 0;
        int minLvl = 0;
        ArrayList<Integer> lst  = new ArrayList<>();

        while(q.size()>0){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair node = q.remove();

                maxLvl = Math.max(maxLvl,node.level);
                minLvl = Math.min(minLvl,node.level);

                map.putIfAbsent(node.level,new ArrayList<>());
                map.get(node.level).add(node.node.data);

                if(node.node.left!=null) q.add(new Pair(node.node.left,node.level-1));
                if(node.node.right!=null) q.add(new Pair(node.node.right,node.level+1));
            }
        }
        for(int i = minLvl; i<=maxLvl;i++){
            List<Integer> lt = map.get(i);
            for(int j=0;j<lt.size();j++){
                lst.add(lt.get(j));
            }
        }
        return lst;
    }
}
