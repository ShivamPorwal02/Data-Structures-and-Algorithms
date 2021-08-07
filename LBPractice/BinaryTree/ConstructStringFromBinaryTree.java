package LoveBabbar.BinaryTree;

public class ConstructStringFromBinaryTree {

    // video reference :- https://www.youtube.com/watch?v=ymIgl_tFAwQ
    static String s;
    public String tree2str(LevelOrderTraversal.TreeNode root) {
        if(root==null) return "";
        if(root.left==null && root.right==null) return root.val+"";
        s = "";
        toString(root);
        return s;
    }
    public void toString(LevelOrderTraversal.TreeNode root){
        if(root==null) return ;

        s+=root.val+"";

        if(root.left==null && root.right==null) return;

        s+='(';
        toString(root.left);
        s+=')';

        if(root.right!=null){
            s+='(';
            toString(root.right);
            s+=')';
        }
    }
}
