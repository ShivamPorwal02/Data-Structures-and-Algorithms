package LoveBabbar.BinaryTree;

import java.util.HashMap;

public class MaximumSumofNonAdjacentNodes {
    static class Node{
        int data;
        Node left,right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    static int getMaxSum(Node root)
    {
        // add your code here
        HashMap<Node,Integer> hm = new HashMap<>();
        return maxSum(root,hm);

    }
    static int maxSum(Node root,HashMap<Node,Integer> hm){
        if(root==null) return 0;

        if(hm.containsKey(root)) return hm.get(root);

        int include = root.data + sumofGrandChildrens(root,hm);

        int exclude = maxSum(root.left,hm)+maxSum(root.right,hm);

        hm.put(root,Math.max(include,exclude));

        return hm.get(root);
    }
    static int sumofGrandChildrens(Node root, HashMap<Node,Integer> hm){
        // if(root==null) return 0;

        int sum = 0;
        if(root.left!=null){
            sum+=maxSum(root.left.left,hm)+maxSum(root.left.right,hm);
        }
        if(root.right!=null){
            sum+=maxSum(root.right.left,hm)+maxSum(root.right.right,hm);
        }
        return sum;
    }

    // Method 2(using Pair)

    static class Pair{
        int include;
        int exclude;
        Pair(int include,int exclude){
            this.include = include;
            this.exclude = exclude;
        }
    }
    static int getMaxSum_(Node root)
    {
        // add your code here
        Pair res = maxSum(root);
        return Math.max(res.include,res.exclude);

    }
    static Pair maxSum(Node root){
        if(root==null){
            Pair sum = new Pair(0,0);
            return sum;
        }
        Pair sum1 = maxSum(root.left);
        Pair sum2 = maxSum(root.right);
        Pair sum = new Pair(0,0);

        sum.include = sum1.exclude+sum2.exclude+root.data;

        sum.exclude = Math.max(sum1.include,sum1.exclude)+ Math.max(sum2.exclude,sum2.include);

        return sum;
    }
}
