package LoveBabbar.LinkedList;

public class SegregateEvenOddLinkedList {
    public static class Node{
        int data;
        Node next;
    }
    Node divide(int N, Node head){
        // code here
        Node evenStart = null;
        Node evenEnd = null;
        Node oddStart = null;
        Node oddEnd = null;
        Node currentNode = head;

        while(currentNode != null) {
            int element = currentNode.data;

            if(element % 2 == 0) {

                if(evenStart == null) {
                    evenStart = currentNode;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                }

            } else {

                if(oddStart == null) {
                    oddStart = currentNode;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                }
            }
            // Move head pointer one step in forward direction
            currentNode = currentNode.next;
        }

        if(evenEnd!=null){
            evenEnd.next = oddStart;
        }
        if(oddEnd!=null){
            oddEnd.next = null;
        }
        head=evenStart==null ? oddStart : evenStart;

        return head;
    }
}
