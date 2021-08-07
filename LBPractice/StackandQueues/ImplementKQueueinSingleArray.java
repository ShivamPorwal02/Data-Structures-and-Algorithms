package LoveBabbar.StackandQueues;

public class ImplementKQueueinSingleArray {
    class kQueue{
        int[] arr;
        int[] next;
        int[] front;
        int n;
        int k;
        int free;
        int prev;
        kQueue(int n,int k){
            arr = new int[n];
            next = new int[n];
            front = new int[n];
            free = 0;
            prev = 0;
            for(int i=0;i<arr.length-1;i++){
                next[i] = i+1;
            }
            for(int i=0;i<k;i++){
                front[i] = -1;
            }
            next[n-1] = -1;
        }

        boolean isFull(){
            return free == -1;
        }
        void push(int data,int qn){
            if(isFull()){
                System.out.println("Queue Overflow");
            }
            int i = free;

            free = next[i];

            if(front[qn]==-1){
                front[qn] = i;
                prev = i;
            }else{
                next[prev] = i;
                prev = i ;
            }
            arr[i] = data;
        }
        int pop(int qn){
            if(isEmpty(qn)){
                System.out.println("Queue UnderFlow");
                return -1;
            }
            int  i = front[qn];
            front[qn] = next[i];
            next[qn] = free;
            free = i;

            return front[qn];
        }
        boolean isEmpty(int qn){
            return front[qn] == -1;
        }
    }
}
