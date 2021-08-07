package LoveBabbar.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubtrees_LeetCode {
    HashMap<String,Integer> hm;
    List<LevelOrderTraversal.TreeNode> lst;
    public List<LevelOrderTraversal.TreeNode> findDuplicateSubtrees(LevelOrderTraversal.TreeNode root) {
        lst = new ArrayList<>();
        hm = new HashMap<>();

        duplicate(root);
        return lst;
    }
    public String duplicate(LevelOrderTraversal.TreeNode root){
        if(root==null) return "|"+"X";

        String x = duplicate(root.left);
        String y = duplicate(root.right);

        String temp = "|"+root.val+x+y; // ye | islia lgae hai taaki differentiate ho ske jaise 11 aur 1 aur 1 aur 11 same lgenege agr hmne | ye ni lgaya to;
        if(hm.containsKey(temp)){
            int prev = hm.get(temp);
            hm.put(temp,prev+1);
            if(hm.get(temp)==2) lst.add(root); // ye hmne islia kia hai taaki agr 2 se jyda baar hui to baar baar na add ho
        }else{
            hm.put(temp,1);
        }
        return temp;
    }
}
