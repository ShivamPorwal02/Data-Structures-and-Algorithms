package LoveBabbar.Heap;

import java.util.PriorityQueue;

public class KthLargestElementinStream {
    class KthLargest {

        PriorityQueue<Integer> pq;
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            pq = new PriorityQueue<>();
            for(int i=0;i<nums.length;i++){
                if(pq.size()<k) pq.add(nums[i]);
                else{
                    if(pq.peek()<nums[i]){
                        pq.remove();
                        pq.add(nums[i]);
                    }
                }
            }
        }

        public int add(int val) {
            if(pq.size()<this.k) pq.add(val);
            else{
                if(pq.peek()<val){
                    pq.remove();
                    pq.add(val);
                }
            }
            return pq.peek();
        }
    }
}
