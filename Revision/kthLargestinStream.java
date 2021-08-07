package Revision;

import java.util.PriorityQueue;

public class kthLargestinStream {
    public void kthLargest(int arr[], int n,int k){
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<arr.length;i++){
            if(pq.size()<k){
                pq.add(arr[i]);
                if(pq.size()==k) System.out.print(pq.peek()+" ");
                else System.out.print(-1+" ");
            }
            else{
                if(arr[i]>pq.peek()){
                    pq.remove();
                    pq.add(arr[i]);
                    System.out.print(pq.peek()+" ");
                }else{
                    System.out.print(pq.peek()+" ");
                }
            }
        }
    }
}
