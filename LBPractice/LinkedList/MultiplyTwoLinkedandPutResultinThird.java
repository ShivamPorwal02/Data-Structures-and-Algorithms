package LoveBabbar.LinkedList;

public class MultiplyTwoLinkedandPutResultinThird {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        return prev;
    }
    public static void addTwoLinkedList(ListNode head,ListNode ans_itr){
        ListNode c1 = head;
        ListNode c2 = ans_itr;

        int carry = 0;
        while(c1!=null || carry>0){

            int data = carry + (c2.next==null ? 0 : c2.next.val)+(c1==null ? 0 : c1.val);

            int nd = data%10;
            carry = data/10;

            if(c2.next==null){
                c2.next = new ListNode(nd);
            }else{
                c2.next.val = nd;
            }
            if(c1!=null) {
                c1 = c1.next;
            }
            c2 = c2.next;

        }

    }
    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode l2_itr = l2;
        ListNode dummy = new ListNode(-1);
        ListNode ansItr = dummy;

        while(l2_itr!=null){
            ListNode prod = multiplyWithDigit(l1,l2_itr.val);
            addTwoLinkedList(prod,ansItr);
            ansItr = ansItr.next;
            l2_itr = l2_itr.next;

        }
        return reverse(dummy.next);
    }
    public static ListNode multiplyWithDigit(ListNode head,int num){
        ListNode dummy = new ListNode(-1);
        ListNode ac = dummy; // answer current
        int carry = 0 ;
        ListNode temp = head;
        while(temp!=null || carry>0){
            int data = carry + (temp==null ? 0 : temp.val)*num;

            int nd = data%10;
            carry = data/10;

            ac.next = new ListNode(nd);

            if(temp!=null){
                temp = temp.next;
            }
            ac = ac.next;
        }
        return dummy.next;
    }
}
