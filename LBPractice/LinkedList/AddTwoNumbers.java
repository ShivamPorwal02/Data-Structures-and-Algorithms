package LoveBabbar.LinkedList;

public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode lst = new ListNode();
        ListNode dummy = lst;
        lst.next = null;
        int carry = 0;
        int sum = 0;
        while(l1!=null && l2!=null){
            int data1 = l1.val;
            int data2 = l2.val;

            sum = data1+data2+carry;
            if(data1+data2+carry>9){
                sum = (data1+data2+carry)%10;
                carry = (data1+data2+carry)/10;
            }else{
                carry = 0;
            }

            ListNode lst1 = new ListNode(sum);
            lst.next = lst1;
            lst = lst.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            if(l1.val+carry>9){
                sum = (l1.val+carry)%10;
                carry = (l1.val+carry)/10;

            }else{
                sum = l1.val+carry;
                carry = 0;
            }
            ListNode lst1 = new ListNode(sum);
            lst.next = lst1;
            lst = lst.next;
            l1 = l1.next;
        }
        while(l2!=null){
            if(l2.val+carry>9){
                sum = (l2.val+carry)%10;
                carry = (l2.val+carry)/10;
            }else{
                sum = l2.val+carry;
                carry = 0;
            }
            ListNode lst1 = new ListNode(sum);
            lst.next = lst1;
            lst = lst.next;
            l2 = l2.next;
        }
        if(carry!=0){
            ListNode lst1 = new ListNode(carry);
            lst.next = lst1;
            lst = lst.next;
        }
        return dummy.next;
    }
    public int size(ListNode head){
        ListNode temp = head;
        int cnt = 0;
        while(temp.next!=null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
}
