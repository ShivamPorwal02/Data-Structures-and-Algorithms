package LoveBabbar.LinkedList;

public class QuickSortOnLinkedList {
        public class Node{
            int data;
            Node next;
        }
        public static Node quickSort(Node head)
        {
            //Your code here
            Node tail = null;
            Node temp = head;

            while(temp.next!=null){
                temp = temp.next;
            }
            tail = temp;
            sort(head,tail);
            return head;
        }
        public static Node Partition(Node start,Node end){

            if(start==end || start == null || end == null){
                return start;
            }

            Node pivot_prev = start;
            Node current = start;
            int pivot = end.data;

            while(start!=end){
                if(start.data<pivot){
                    int temp = current.data;
                    current.data = start.data;
                    start.data = temp;

                    pivot_prev = current;
                    current = current.next;
                }
                start  = start.next;
            }
            int temp = current.data;
            current.data = end.data;
            end.data = temp;
            return pivot_prev;
        }

        public static void sort(Node start,Node end){
            if(start==end || start == null || start == end.next){
                return ;
            }
            Node pivot_prev = Partition(start,end);
            sort(start,pivot_prev);
            sort(pivot_prev.next,end);
        }
    }
