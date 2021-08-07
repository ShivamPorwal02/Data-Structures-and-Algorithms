package LoveBabbar.BinaryTree;

import java.util.HashMap;

public class DuplicateSubTreeinBinaryTree {


    class Node{
        int data;
        Node left,right;
        Node(int data,Node left,Node right){
            this.data= data;
            this.left = left;
            this.right = right;
        }
    }
    HashMap<String,Integer> hm;
    int dupSub(Node root) {
        // code here
        hm = new HashMap<>();
        duplicate(root);
        // System.out.println(hm);
        for(String s : hm.keySet()){
            if(hm.get(s)>1 && s.length()>3){
                return 1;
            }
        }
        return 0;
    }

    String duplicate(Node root){
        if(root==null) return "X";

        String x = duplicate(root.left);
        String y = duplicate(root.right);

        String temp = ""+root.data+x+y;

        if(hm.containsKey(temp)){
            int prev = hm.get(temp);
            hm.put(temp,prev+1);
        }else{
            hm.put(temp,1);
        }
        return temp;
    }
}
