package LoveBabbar.LinkedList;

public class CycleStartingPointinLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null || fast.next==null){
            return null;
        }

        slow = head;
        while(slow!=fast){
            slow= slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
