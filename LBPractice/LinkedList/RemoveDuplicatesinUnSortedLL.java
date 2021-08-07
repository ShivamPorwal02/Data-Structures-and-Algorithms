package LoveBabbar.LinkedList;

import java.util.HashSet;

public class RemoveDuplicatesinUnSortedLL {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    public Node removeDuplicates(Node head)
    {
        // Your code here

        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        HashSet<Integer> hs = new HashSet<>();

        Node temp = head;
        Node dummy = new Node(1);
        Node prev = head;
        dummy.next = prev;
        while(temp!=null){
            if(hs.contains(temp.data)){
                prev.next = temp.next;
            }else{
                hs.add(temp.data);
                prev = temp;
            }
            temp = temp.next;
        }
        return dummy.next;
    }
}
