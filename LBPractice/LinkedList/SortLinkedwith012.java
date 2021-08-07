package LoveBabbar.LinkedList;

public class SortLinkedwith012 {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static Node segregate(Node head)
    {
        // Time Complexity --> O(N) , Space constant hai but ism copy krre hai to syd acha ni hai
        int[] arr = new int[3];

        Node temp = head;

        while(temp!=null){
            arr[temp.data]++;
            temp = temp.next;
        }

        Node dummy = head;
        Node x = new Node(1);
        x.next = dummy;

        while(arr[0]>0){
            dummy.data = 0;
            dummy = dummy.next;
            --arr[0];
        }
        while(arr[1]>0){
            dummy.data = 1;
            dummy = dummy.next;
            --arr[1];
        }
        while(arr[2]>0){
            dummy.data = 2;
            dummy = dummy.next;
            --arr[2];
        }

        return x.next;
    }
}
