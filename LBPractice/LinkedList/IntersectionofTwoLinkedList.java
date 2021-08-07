package LoveBabbar.LinkedList;

public class IntersectionofTwoLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
    }
    // issm hm value ni compare krre ism hm reference compare krre hai
    public ListNode intersetion(ListNode headA,ListNode headB){
        int size1 = size(headA);
        int size2 = size(headB);
        if(size1>size2){
            while(size1!=size2){
                headA = headA.next;
                size1--;
            }
        }else{
            while(size1!=size2){
                headB = headB.next;
                size2--;
            }
        }
        while(headA!=headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // complexity same hi hai bss bahut chota code hai iska video dekhlo acha concept hai
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1!=temp2){
            temp1 = temp1==null ? headB : temp1.next;
            temp2 = temp2==null ? headA : temp2.next;
        }
        return temp1;
    }
}
