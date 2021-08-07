package LoveBabbar.BinaryTree;

public class DeleteNodesWithGivenValue {
    public LevelOrderTraversal.TreeNode removeLeafNodes(LevelOrderTraversal.TreeNode node, int target) {
        if(node==null) return null;

        node.left = removeLeafNodes(node.left,target);
        node.right = removeLeafNodes(node.right,target);
        return node.left==null && node.right ==null && node.val==target ? null : node ;
    }
}
