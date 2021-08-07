package LoveBabbar.BinaryTree;

public class ConstructBinaryTreeFromPostOrderandInorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
        static int idx;
        public TreeNode buildTree( int[] inorder,int[] postorder) {

            idx = inorder.length-1;
            TreeNode root = Tree(postorder,inorder,0,inorder.length-1);
            return root;
        }
        public TreeNode Tree(int[] postorder,int[] inorder,int start,int end){
            if(start > end) return null;

            int curr = postorder[idx];
            idx--;
            TreeNode node = new TreeNode(curr);

            if(start==end) return node;

            int pos = search(curr,inorder,start,end);

            node.right = Tree(postorder,inorder,pos+1,end);
            node.left = Tree(postorder,inorder,start,pos-1);

            return node;

        }
        public int search(int curr,int[] inorder,int start,int end){
            for(int i=start;i<=end;i++){
                if(inorder[i]==curr) return i;
            }
            return -1;
        }
}
