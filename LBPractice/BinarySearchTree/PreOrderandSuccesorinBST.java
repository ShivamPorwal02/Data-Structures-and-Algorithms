package LoveBabbar.BinarySearchTree;

public class PreOrderandSuccesorinBST {

    class Node{
        int data;
        Node left;
        Node right;
    }
    class Res{
        Node pre;
        Node succ;
    }
    static Node pred;
    static Node succ;
    static int state;
    public static void findPreSuc(Node root, Res p, Res s, int key)
    {
        // add your code here
        pred = null;
        succ = null;
        state = Integer.MAX_VALUE;
        preSucc(root,key);
        p.pre = pred;
        s.succ = succ;
        return;

    }

    // ye normal tareeka hai BST ki kooi fyda ni uthaya
    public static void preSucc(Node root,int data){
        if(root==null) return;
        preSucc(root.left,data);

        if(root.data<data){
            pred = root;
        }
        if(root.data>data && root.data < state ){
            succ = root;
            state = root.data;
        }
        preSucc(root.right,data);
    }

    // ism hmne BST ka fyda uthaya hai

    public static void preSucc_(Node root,int key){
        if(root==null) return;

        if(root.data == key){

            if(root.left != null){
                // max nikal lo left ka
                Node tmp = root.left;

                while(root.right!=null){
                    tmp = tmp.right;
                    pred = tmp;
                }
            }

            if(root.right!=null){

                // min nikal to right ka

                Node tmp = root.right;
                while(root.left!=null){
                    tmp = tmp.left;
                    succ = tmp;
                }
            }
            return;
        }
        if(root.data> key){
            succ = root;
            preSucc_(root.left,key);
        }else{
            pred = root;
            preSucc_(root.right,key);
        }
    }
}
