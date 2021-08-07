package LoveBabbar.Heap;

import java.util.PriorityQueue;

public class kthLargestElements {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            if(pq.size()<k) pq.add(arr[i]);
            else{
                if(pq.peek()<arr[i]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        int[] ans = new int[k];
        int i = k-1;
        while(pq.size()>0){
            ans[i] = pq.remove();
            i--;
        }
        return ans;
    }
}
