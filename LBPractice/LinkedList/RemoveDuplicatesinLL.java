package LoveBabbar.LinkedList;

public class RemoveDuplicatesinLL {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        ListNode prev = head;
        ListNode now = head.next;

        while(now!=null){
            while(now!=null && prev.val==now.val){
                now = now.next;
            }
            prev.next = now;
            prev = now;
            now = now==null ? null : now.next;
        }
        return head;
    }
}
