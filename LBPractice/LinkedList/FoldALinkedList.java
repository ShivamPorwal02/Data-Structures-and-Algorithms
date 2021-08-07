package LoveBabbar.LinkedList;

public class FoldALinkedList {
    public  static class ListNode{
        int val;
        ListNode next;
    }
    ListNode fleft;
    public  void reorderList(ListNode head){
        fleft = head;
        fold(head,0,size(head));
    }
    public  void fold(ListNode fright,int floor,int size){
        if(fright==null){
            return;
        }

        fold(fright.next,floor+1,size);

        if(floor>size/2){
            ListNode temp = fleft.next;
            fleft.next = fright;
            fright.next = temp;
            fleft = temp;
        }else if(floor==size/2){
            fright.next = null;
        }

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
}
