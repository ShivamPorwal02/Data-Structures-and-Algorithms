package LoveBabbar.LinkedList;

public class MoveLastElementtoFirstElement {
    public static class Node{
        int data;
        Node next;
    }
    public static Node firstToLast(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        if(head.next.next==null){
            Node temp = head.next;
            temp.next = head;
            head.next = null;
            return temp;
        }
        Node newhead = new Node();
        Node temp = head;
        while(temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
        newhead.next = head;
        return newhead;
    }


}
