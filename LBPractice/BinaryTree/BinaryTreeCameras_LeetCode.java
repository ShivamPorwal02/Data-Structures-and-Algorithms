package LoveBabbar.BinaryTree;

public class BinaryTreeCameras_LeetCode {

    // video link -> https://www.youtube.com/watch?v=uoFrIIrp5_g
    static int cameras ;
    public int minCameraCover(LevelOrderTraversal.TreeNode root) {
        cameras = 0;
        int ans = minCamera(root);
        return ans==-1 ? ++cameras : cameras;
    }
    public int minCamera(LevelOrderTraversal.TreeNode root){
        if(root==null) return 1;

        int lchild = minCamera(root.left);
        int rchild = minCamera(root.right);

        if(lchild==-1 || rchild==-1){
            cameras++;
            return 0;
        }else if(lchild ==0 || rchild == 0){
            return 1;
        }else if(lchild==1 && rchild == 1){
            return -1;
        }
        return 1;
    }
}
