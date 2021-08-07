package Revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lst = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int left = i+1;
            int right = nums.length-1;
            int tar = -nums[i];
            while(left<right){
                if(nums[left]+nums[right]>tar){
                    right--;
                }else if(nums[left]+nums[right]<tar){
                    left++;
                }else{
                    ArrayList<Integer> slst = new ArrayList<>();
                    slst.add(nums[i]);
                    slst.add(nums[left]);
                    slst.add(nums[right]);
                    lst.add(slst);
                    while(left<right && nums[left]==slst.get(1)){
                        left++;
                        // duplicate rokne k lia
                    }
                    while(left<right && nums[left]==slst.get(2)){
                        right--;
                        // duplicate rokne k lia
                    }
                }
            }
            while(i+1<nums.length && nums[i+1]==nums[i]){
                i++;
            }
        }
        return lst;
    }
}
