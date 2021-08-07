package LoveBabbar.LinkedList;

public class Add1ToLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static int size;
    public static Node addOne(Node head)
    {
        //code here.
        size = siZe(head);
        int oc = add(head,1);
        if(oc>0){
            Node node = new Node(1);
            node.next = head;
            return node;
        }
        return head;

    }
    public static int add(Node head,int floor){
        if(head==null){
            return 0;
        }
        int oc = add(head.next,floor+1);
        int nc = 0;
        if(floor == size){
            int nd = (head.data+oc+1)%10;
            nc = (head.data+oc+1)/10;
            head.data = nd;
        }else if(oc>0){
            int nd = (head.data+oc)%10;
            nc = (head.data+oc)/10;
            head.data = nd;
        }
        return nc;
    }
    public static int siZe(Node head){
        Node temp = head;
        int cnt = 0 ;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
}
