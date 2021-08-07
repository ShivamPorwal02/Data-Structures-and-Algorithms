package LoveBabbar.Heap;

import java.util.PriorityQueue;

public class MergeKsortedList {
    class Node{
        int data;
        Node next;

        Node(int key)
        {
            data = key;
            next = null;
        }
    }
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.data-b.data);

        Node dummy = new Node(-1);
        Node res = dummy;

        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
        }
        while(pq.size()>0){
            Node temp = pq.remove();
            res.next  = new Node(temp.data);
            res = res.next;
            if(temp.next!=null){
                temp = temp.next;
                pq.add(temp);
            }
        }


        return dummy.next;
    }
}
