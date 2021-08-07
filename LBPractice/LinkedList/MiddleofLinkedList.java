package LoveBabbar.LinkedList;

public class MiddleofLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode middleNode(ListNode head) {
        if(head.next == null){
            return head;
        }
        if(head.next.next == null){
            return head.next;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
