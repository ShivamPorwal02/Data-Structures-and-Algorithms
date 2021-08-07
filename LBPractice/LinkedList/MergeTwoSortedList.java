package LoveBabbar.LinkedList;

public class MergeTwoSortedList {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        ListNode lst = null;
        ListNode dn = new ListNode();
        if(temp1.val<temp2.val){
            lst = new ListNode();
            lst.val = temp1.val;
            dn.next = lst;
            temp1 = temp1.next;
        }else{
            lst = new ListNode();
            lst.val = temp2.val;
            dn.next = lst;
            temp2 = temp2.next;

        }
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                ListNode x = new ListNode(temp1.val,null);
                lst.next = x;
                lst = lst.next;
                temp1 = temp1.next;
            }else{
                ListNode x = new ListNode(temp2.val,null);
                lst.next = x;
                lst = lst.next;
                temp2 = temp2.next;
            }
        }
        while(temp1!=null){
            ListNode x = new ListNode(temp1.val,null);
            lst.next = x;
            lst = lst.next;
            temp1 = temp1.next;
        }
        while(temp2!=null){
            ListNode x = new ListNode(temp2.val,null);
            lst.next = x;
            lst = lst.next;
            temp2 = temp2.next;
        }

        lst.next = null;
        return dn.next;

    }
}
