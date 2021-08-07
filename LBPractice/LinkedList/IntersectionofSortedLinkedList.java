package LoveBabbar.LinkedList;

public class IntersectionofSortedLinkedList {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public static Node findIntersection(Node head1, Node head2)
    {
        // code here.
        Node temp1 = head1;
        Node temp2 = head2;
        Node lst = new Node(1);
        Node dummy = new Node(1);
        dummy.next = lst;
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                temp1 = temp1.next;
            }else if(temp1.data>temp2.data){
                temp2 = temp2.next;
            }else{
                Node newNode = new Node(temp1.data);
                lst.next = newNode;
                lst = lst.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        // lst.next = null;
        return dummy.next.next;
    }
}
