package LoveBabbar.DynamicProgramming;

import java.util.HashMap;

public class LongestArithmeticSubsequenceofGivenDifference {
    public int longestSubsequence(int[] nums, int difference) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int res = 1;
        for(int num : nums){
            hm.put(num,hm.getOrDefault(num-difference,0)+1);
            res = Math.max(res,hm.get(num));
        }
        return res;
    }
}
