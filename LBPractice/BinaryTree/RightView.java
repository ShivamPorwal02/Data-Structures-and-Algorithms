package LoveBabbar.BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightView {
    // similar hai left view k method2 same hai mera waha
    public List<Integer> rightSideView(LevelOrderTraversal.TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        rightview(root, lst, 0);
        return lst;
    }

    public void rightview(LevelOrderTraversal.TreeNode root, List<Integer> lst, int depth) {
        if (root == null) return;

        if (lst.size() == depth) {
            lst.add(root.val);
        }
        rightview(root.right, lst, depth + 1);
        rightview(root.left, lst, depth + 1);
    }

    public List<Integer> rightSideView_mie(LevelOrderTraversal.TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<LevelOrderTraversal.TreeNode> q = new ArrayDeque<>();
        ArrayList<Integer> lst = new ArrayList<>();
        q.add(root);
        ArrayList<Integer> lst1 = new ArrayList<>();
        while (q.size() > 0) {
            int sizeofq = q.size();
            lst1 = new ArrayList<>();
            for (int i = 0; i < sizeofq; i++) {
                LevelOrderTraversal.TreeNode rem = q.remove();
                lst1.add(rem.val);

                if (rem.left != null) q.add(rem.left);
                if (rem.right != null) q.add(rem.right);
            }
            lst.add(lst1.get(lst1.size() - 1));
        }
        return lst;
    }

}
