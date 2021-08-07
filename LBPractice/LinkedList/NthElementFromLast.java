package LoveBabbar.LinkedList;

public class NthElementFromLast {
    public static class Node{
        int data;
        Node next;
    }
    int getNthFromLast(Node head, int n)
    {
        // Your code here
        if(n==1 && head.next==null){
            return head.data;
        }
        Node slow = head;
        Node fast = head;

        for(int i=0;i<n;i++){
            if(fast==null){
                return -1; // ye jbb n> size of LinkedList
            }
            fast = fast.next;
        }

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }
}
