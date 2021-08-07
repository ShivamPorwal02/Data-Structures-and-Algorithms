package LoveBabbar.LinkedList;

import java.util.HashMap;

public class CloneALinkedListwithRandomPointer {
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {

        // O(N) time and O(N) space

        HashMap<Node,Node> hm = new HashMap<>();

        Node temp = head;

        while(temp!=null){
            Node newCopy = new Node(temp.val);
            hm.put(temp,newCopy);
            temp = temp.next;
        }

        temp = head;

        while(temp!=null){
            Node rand = temp.random;
            hm.get(temp).random = hm.get(rand);
            hm.get(temp).next = temp.next==null? null : hm.get(temp.next);
            temp = temp.next;
        }
        return hm.get(head);
    }
    public Node copyRandomList_method2(Node head) {
        // space O(1) and O(n) complexity
        Node iter = head;
        Node front = head;

        // step 1
        while(iter!=null){
            front = iter.next;

            Node copy = new Node(iter.val);
            iter.next = copy;
            copy.next = front;

            iter = front;
        }

        // step 2

        iter = head;
        while(iter!=null){
            if(iter.random!=null){
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }

        // step3
        iter = head;
        Node pseudohead = new Node(0);
        Node copy = pseudohead;

        while(iter!=null){

            front = iter.next.next;
            copy.next = iter.next;
            copy = copy.next;

            iter.next = front;
            iter = front;
        }
        return pseudohead.next;

    }
}
