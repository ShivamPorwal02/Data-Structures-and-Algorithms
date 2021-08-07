package LoveBabbar.LinkedList;

public class MergeTwoSortedList_INPLACE {

    // video link :- https://www.youtube.com/watch?v=Xb4slcp1U38
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        if(l2.val<l1.val){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode res = l1;

        while(l1!=null && l2!=null){
            ListNode prev = null;
            while(l1!=null && l1.val<=l2.val){
                prev = l1;
                l1 = l1.next;
            }
            prev.next = l2;

            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        return res;
    }
}
