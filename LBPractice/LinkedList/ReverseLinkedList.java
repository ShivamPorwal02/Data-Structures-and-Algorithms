package LoveBabbar.LinkedList;

public class ReverseLinkedList {
    public static class Node{
        int val;
        Node next;
    }
    public static class LinkedList{
        // ITERATIVE (DATA)
        public Node reverseList(Node head) {
            if(head==null){
                return null;
            }
            int i = 0;
            int j = size(head)-1;

            while(i<j){
                Node left = getNodeAt(head,i);
                Node right = getNodeAt(head,j);

                int temp = left.val;
                left.val = right.val;
                right.val = temp;

                i++;
                j--;
            }
            return head;
        }
        private Node getNodeAt(Node head,int idx){
            Node temp = head;
            for(int i=0;i<idx;i++){
                temp = temp.next;
            }
            return temp;
        }
        private int size(Node head){
            int size = 0;
            Node temp = head;
            while(temp!=null){
                temp = temp.next;
                size++;
            }
            return size;
        }

        // ITERATIVE (POINTER)

        public static Node reverseLL_PointerIterative(Node head){
            if(head==null){
                return null;
            }
            if(head.next==null){
                return head;
            }
            Node prev = null;
            Node nex = null;
            while(head!=null){
                Node nexhead = head.next;
                head.next = prev;
                prev = head;
                head = nexhead;
            }
            return prev;
        }

        // RECURSIVE

        public static Node reverseLL_Recursive(Node head){

            // agr smjh ni aae to gfg prr diagram hai msst smjh aajega
            if(head==null || head.next == null){
                return head;
            }
            Node rest = reverseLL_Recursive(head.next); //faith rhkenge ki vo pura sahi hok hmare pass aaega hme bss first ko sahi se jodna hai
            head.next.next = head;
            head.next = null;
            return rest;
        }
    }
}
