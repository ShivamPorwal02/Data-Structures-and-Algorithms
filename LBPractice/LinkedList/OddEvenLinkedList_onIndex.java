package LoveBabbar.LinkedList;

public class OddEvenLinkedList_onIndex {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;

        ListNode res = new ListNode();
        res.next = odd;
        ListNode temp = head.next;

        while(even!=null && even.next!=null){
            ListNode temp2 = even.next;
            even.next = even.next.next;
            odd.next = temp2;
            odd = odd.next;
            even = even.next;
        }
        odd.next = temp;
        return res.next;
    }
}
