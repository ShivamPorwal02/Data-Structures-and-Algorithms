package LoveBabbar.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->hm.get(b)-hm.get(a));
        pq.addAll(hm.keySet());

        int[] ans = new int[k];
        int i =0 ;
        while(k!=0){
            ans[i] = pq.remove();
            i++;
            k--;
        }
        return ans;
    }
}
