package LoveBabbar.BinaryTree;

public class ShadowofBinaryTree_Pep_width {
    public void shadow(LevelOrderTraversal.TreeNode root,int level,int[] ans){
        if(root==null) return;

        ans[0] = Math.min(ans[0],level);
        ans[1] = Math.max(ans[1],level);

        shadow(root.left,level-1,ans);
        shadow(root.right,level+1,ans);
    }
    public int shadowBinaryTree(LevelOrderTraversal.TreeNode root){
        int[] ans = new int[2];
        shadow(root,0,ans);
        return ans[1]-ans[0]+1;
    }
}
