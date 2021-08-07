package BinarySearchTree;

public class IntroBST {
    public static class Node{
        int data;
        Node left;
        Node right;
        Node(int data,Node left,Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public static Node construct(int[] arr,int lo,int hi){
        if(lo>hi){
           return null;
        }
        int mid = (lo+hi)/2;
        int data = arr[mid];
        Node lc = construct(arr,lo,mid-1);
        Node rc = construct(arr,mid+1,hi);
        Node node = new Node(data,lc,rc);
        return node;
    }
    public static void display(Node node){
        if(node==null){
            return;
        }
        String s = "";
        s+=node.left==null?".":node.left.data+" ";
        s+="<-"+node.data+"->";
        s+=node.right==null?".":node.right.data+" ";
        System.out.println(s);
        display(node.left);
        display(node.right);
    }
    public static void main(String[] arr) throws Exception{
        int[] a = {12,25,37,50,62,75,87};
        Node root = construct(a,0,a.length-1);
        display(root);
    }
}
