package LoveBabbar.LinkedList;

public class LeetCodeDeleteNthFromLast {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n>=1 && head.next==null){
            return null;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        for(int i=0;i<n;i++){
            fast = fast.next;
        }

        while(fast!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        if(prev==null){
            return head.next;  // ye [1,2] n=2 jaise cases m
        }
        prev.next = slow.next == null ? null : slow.next ;
        return head;

    }
}
