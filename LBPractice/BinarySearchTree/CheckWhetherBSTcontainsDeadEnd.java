package LoveBabbar.BinarySearchTree;

public class CheckWhetherBSTcontainsDeadEnd {
    static class Node{
        int data;
        Node left;
        Node right;
    }
    static boolean flag;
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        flag = false;
        deadEnd(root,-100000,100000);
        return flag;
    }

    public static void deadEnd(Node root,int min,int max){
        if(root==null) {
            return ;
        }
        if(flag==true) {
            return;
        }
        // checing ki leaf node hai
        if(root.left == null && root.right == null){
            if(min == max || max == 1) flag = true;

            // agr min == max hai to dono ki rnage m kchni aa skta
            // max = 1 ka ye mtlb hai ki natural number chahia agr max hi 1 hai to usse chota to
            // possible ni natural number

            return;
        }

        // -1 aur +1 islia kia hai range nikalne k lia mtlb ki itne m hona chahai
        deadEnd(root.left,min,root.data-1);
        deadEnd(root.right,root.data+1,max);

        return ;
    }
}
