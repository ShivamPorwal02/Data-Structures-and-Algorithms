package LoveBabbar.LinkedList;

public class DeleteNodeshavingHigherElementsonRight {
    public static class Node{
        int data;
        Node next;
    }
    Node compute(Node head)
    {
        // your code here
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        Node revHead = reverse(head);

        Node curr = revHead;
        Node res = curr;
        Node maxNode = revHead;

        while(curr!=null && curr.next!=null){

            if(curr.next.data<maxNode.data){
                Node temp = curr.next;
                curr.next = temp.next;
                temp = null;
            }else{
                curr = curr.next;
                maxNode = curr;
            }
        }

        head = reverse(res);

        return head;
    }
    public Node reverse(Node head){
        Node curr = head;
        Node prev = null;
        while(curr!=null){
            Node forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
}
