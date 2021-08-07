package LoveBabbar.LinkedList;

public class AddTwoNumbers_II {
    public static class ListNode{
        int val;
        ListNode next;
    }
    ListNode lst = null;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size1 = size(l1);
        int size2 = size(l2);
        int oc=add(l1,size1,l2,size2);
        lst = null; // ye static to krna pdega
        if(oc>0){
            addFirst(oc);
        }
        return lst;
    }
    public int add(ListNode l1,int pv1,ListNode l2,int pv2){
        if(l1==null && l2==null){
            return 0 ;
        }
        int data = 0;
        if(pv1>pv2){
            int oc = add(l1.next,pv1-1,l2,pv2);
            data = l1.val+oc;
        }else if(pv1<pv2){
            int oc = add(l1,pv1,l2.next,pv2-1);
            data = l2.val+oc;
        }else{
            int oc = add(l1.next,pv1-1,l2.next,pv2-1);
            data = l1.val+l2.val+oc;
        }
        int nd = data%10;
        int nc = data/10;

        addFirst(nd);
        return nc;
    }
    public int size(ListNode head){
        ListNode temp = head;
        int cnt = 0;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
    public void addFirst(int val) {
        ListNode temp = new ListNode();
        temp.val = val;
        temp.next = lst;
        lst = temp;
    }
}
