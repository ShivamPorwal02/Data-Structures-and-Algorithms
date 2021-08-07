package LoveBabbar.BinarySearchTree;

import java.util.ArrayList;

public class BrotherFromDiffrentRoot {
    class Node{
        int data;
        Node left;
        Node right;
    }
    public static int countPairs(Node root1, Node root2, int x)
    {
        // your code here

        ArrayList<Integer> lst1 = new ArrayList<>();
        inorder(root1,lst1);
        ArrayList<Integer> lst2 = new ArrayList<>();
        inorder(root2,lst2);

        int cnt = 0;
        int i = 0;
        int j = lst2.size()-1;
        while(i<lst1.size() && j>=0){
            if(lst1.get(i)+lst2.get(j)==x){
                cnt++;
                i++;
                j--;
            }
            else if(lst1.get(i)+lst2.get(j)>x){
                j--;
            }else{
                i++;
            }
        }
        return cnt;
    }

    public static ArrayList<Integer> inorder(Node root,ArrayList<Integer> lst){
        if(root==null) return lst;

        inorder(root.left,lst);
        lst.add(root.data);
        inorder(root.right,lst);

        return lst;
    }
}
