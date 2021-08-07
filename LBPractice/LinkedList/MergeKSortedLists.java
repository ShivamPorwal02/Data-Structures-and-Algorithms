package LoveBabbar.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                return o1.val-o2.val;
            }

        });
        int k  = lists.length;

        ListNode dummy = new ListNode(-1);
        ListNode ac = dummy;

        for(int i=0;i<k;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }

        while(pq.size()>0){
            ListNode temp = pq.remove();
            ac.next = new ListNode(temp.val);
            ac = ac.next;
            if(temp.next!=null){
                temp = temp.next;
                pq.add(temp);
            }
        }
        return dummy.next;
    }
}
