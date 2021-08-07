package LoveBabbar.LinkedList;

import java.util.HashMap;

public class CycleinLinkedList {
    public static class ListNode{
        int val;
        ListNode next;
    }
    public static boolean Method_mine(ListNode head){
            HashMap<ListNode,Integer> hm = new HashMap<>();

            ListNode temp = head;
            while(temp!=null){
                if(hm.containsKey(temp)){
                    return true;
                }else{
                    hm.put(temp,1);
                }
                temp = temp.next;
            }
            return false;
        }
    public static boolean bestMethod(ListNode head){
        if(head==null ||head.next==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;

    }
}
