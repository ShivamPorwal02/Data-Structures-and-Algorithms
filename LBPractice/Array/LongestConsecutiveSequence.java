package LoveBabbar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
         // nlogn

        Arrays.sort(nums);
        if(nums.length==0){
            return 0;
        }
        int max = 1;
        int l=1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1]){
                l++;
                if(l>max){
                    max = l;
                }
            }else if(nums[i]==nums[i+1]){

            }else{
                l=1;
            }
        }
        return max;
    }
    //  n


//    public int longestConsecutive(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//
//        for(int val : nums){
//            set.add(val);
//        }
//        int max = 0 ;
//
//        for(int val: nums){
//            if(!set.contains(val-1)){
//                int m = val+1;
//                while(set.contains(m)){
//                    m++;
//                }
//                max = Math.max(max,m-val);
//            }
//        }
//        return max;
//    }
}
