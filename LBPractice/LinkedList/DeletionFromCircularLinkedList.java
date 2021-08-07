package LoveBabbar.LinkedList;

public class DeletionFromCircularLinkedList {
    public static class Node{
        int data;
        Node next;
    }
    public static Node removeFirst(Node head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }
        Node temp = head;
        while(temp.next!=head){
            temp = temp.next;
        }
        temp.next = head.next;
        head = head.next;
        return head;
    }
    public static Node removeLast(Node head){
        Node temp = head;
        if(head==null){
            return null;
        }
        if(head.next==null){
            head.next = null;
            return head;
        }
        while(temp.next.next!=head){
            temp = temp.next;
        }
        temp.next.next = head;
        return head;

    }
    public static Node remove(Node head,int key){
        if(head.data==key){
            return removeFirst(head);
        }
        Node temp = head;
        while (temp!=head){
            Node prev = temp;
            if(temp.data==key){
                if(temp.next==head){
                    removeLast(head);
                }else{
                    prev.next = temp.next;
                }
            }

            temp = temp.next;

        }
        return head;
    }
}
