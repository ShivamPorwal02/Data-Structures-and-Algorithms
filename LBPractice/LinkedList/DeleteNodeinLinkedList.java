package LoveBabbar.LinkedList;

public class DeleteNodeinLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public void deleteNode(ListNode node) {

        ListNode prev = node;
        ListNode curr = node.next;
        while(curr!=null){
            prev.val = curr.val;
            prev.next = curr.next;
            prev = prev.next;
            curr = curr.next;
        }
    }
}
