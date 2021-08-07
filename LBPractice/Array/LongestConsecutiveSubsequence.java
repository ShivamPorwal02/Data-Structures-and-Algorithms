package LoveBabbar;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int val : nums){
            set.add(val);
        }
        int max = 0 ;

        for(int val: nums){
            if(!set.contains(val-1)){
                int m = val+1;
                while(set.contains(m)){
                    m++;
                }
                max = Math.max(max,m-val);
            }
        }
        return max;
    }
}
