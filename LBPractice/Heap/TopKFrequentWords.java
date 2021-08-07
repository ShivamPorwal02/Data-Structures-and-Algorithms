package LoveBabbar.Heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] nums, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b)->hm.get(a)==hm.get(b) ? a.compareTo(b) : hm.get(b)-hm.get(a));
        pq.addAll(hm.keySet());

        List<String> lst = new ArrayList<>();
        while(k!=0){
            lst.add(pq.remove());
            k--;
        }
        return lst;
    }
}
