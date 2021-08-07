package LoveBabbar.Heap;

import java.util.HashMap;

public class SubArraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1); // islia kyuki agr k=0 hua to 0 to ek khud hi hogya islia daal dia ese
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-k)){
                ans+=hm.get(sum-k);
            }
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
