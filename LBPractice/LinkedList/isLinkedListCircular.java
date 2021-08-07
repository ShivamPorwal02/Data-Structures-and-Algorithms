package LoveBabbar.LinkedList;

public class isLinkedListCircular {
    public static class Node{
        int data;
        Node next;
    }
    boolean isCircular(Node head)
    {
        // Your code here
        if(head.next==null) return false;
        Node temp = head.next;
        while(temp!=null){
            if(temp==head){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
