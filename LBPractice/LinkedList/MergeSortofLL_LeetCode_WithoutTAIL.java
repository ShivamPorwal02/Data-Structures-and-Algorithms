package LoveBabbar.LinkedList;

public class MergeSortofLL_LeetCode_WithoutTAIL {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode middle = mid(head);
        ListNode newhead = middle.next;
        middle.next = null;  // yha prr inhone mid se link tod di aur alg alg do list bna dia // imp step

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(newhead);

        return merge(l1,l2);

    }
    private ListNode mid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        if(head==null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    private ListNode merge(ListNode l1,ListNode l2){
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
            while(l1!=null &&l1.val <= l2.val){
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
