package LoveBabbar.LinkedList;

public class MergeSortofLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode sortList(ListNode head) {

        // ye mera tarreka hai jbb aapko tail ni de rkhi to khud nikaal k krdia

        // ek cheez imp ye ki issm jo even k case m baad wala mid lete the na yha vo ni kia yaha hmne pehle wala mid hi consitder kia hai
        if(head==null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode tailList =  tail(head);
        return mergeSort(head,tailList);
    }
    public ListNode mergeSort(ListNode head,ListNode tail){

        if(head==tail){
            ListNode n = new ListNode(head.val);
            return n;
        }
        ListNode middle = mid(head,tail);
        ListNode l1 = mergeSort(head,middle);
        ListNode l2 = mergeSort(middle.next,tail);
        return merge(l1,l2);

    }

    private ListNode tail(ListNode head){
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        return temp;
    }
    private ListNode mid(ListNode head,ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        while(fast!=tail && fast.next!=tail){
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
