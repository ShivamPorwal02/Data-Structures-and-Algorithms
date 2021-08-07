package LoveBabbar.BinaryTree;

import java.util.ArrayList;

public class LowestCommonAncestor {
    public LevelOrderTraversal.TreeNode lowestCommonAncestor(LevelOrderTraversal.TreeNode root, LevelOrderTraversal.TreeNode p, LevelOrderTraversal.TreeNode q) {
        if(root==null) return null;
        // if(p==null) return q
        ArrayList<LevelOrderTraversal.TreeNode> lst1 = NodetoRootpath(root,p);
        ArrayList<LevelOrderTraversal.TreeNode> lst2 = NodetoRootpath(root,q);

        int i = lst1.size()-1;
        int j=lst2.size()-1;
        while(i>=0 && j>=0 && lst1.get(i)==lst2.get(j)){
            i--;
            j--;
        }
        return lst1.get(i+1);
    }
    public ArrayList<LevelOrderTraversal.TreeNode> NodetoRootpath(LevelOrderTraversal.TreeNode root, LevelOrderTraversal.TreeNode target){
        if(root==null){
            return new ArrayList<>();
        }
        if(root==target){
            ArrayList<LevelOrderTraversal.TreeNode> lst = new ArrayList<>();
            lst.add(root);
            return lst;
        }
        ArrayList<LevelOrderTraversal.TreeNode> lst1 = NodetoRootpath(root.left,target);
        if(lst1.size()>0){
            lst1.add(root);
            return lst1;
        }
        ArrayList<LevelOrderTraversal.TreeNode> lst2 = NodetoRootpath(root.right,target);
        if(lst2.size()>0){
            lst2.add(root);
            return lst2;
        }
        return new ArrayList<>();
    }

    // ye best hai bina space k

    public LevelOrderTraversal.TreeNode BestMethod(LevelOrderTraversal.TreeNode root, LevelOrderTraversal.TreeNode p, LevelOrderTraversal.TreeNode q){
        if(root==p || root==q || root==null) return root;
        LevelOrderTraversal.TreeNode left = lowestCommonAncestor(root.left,p,q);
        LevelOrderTraversal.TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        else if(right==null) return left;
        return root;
    }
}
