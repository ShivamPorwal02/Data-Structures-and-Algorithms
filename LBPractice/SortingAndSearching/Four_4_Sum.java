package LoveBabbar.SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;

public class Four_4_Sum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
        // code here
        ArrayList<ArrayList<Integer>> lst =  new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int left = j+1;
                int right = nums.length-1;
                int tar = target - nums[i] - nums[j];
                while(left<right){
                    if(nums[left]+nums[right]<tar){
                        left++;
                    }else if(nums[left]+nums[right]>tar){
                        right--;
                    }else{
                        ArrayList<Integer> slst = new ArrayList<>();
                        slst.add(nums[i]);
                        slst.add(nums[j]);
                        slst.add(nums[left]);
                        slst.add(nums[right]);
                        lst.add(slst);
                        while(left<right && nums[left]==slst.get(2)){
                            left++;
                        }
                        while(left<right && nums[right]==slst.get(3)){
                            right--;
                        }
                    }
                }
                while(j+1<nums.length && nums[j+1]==nums[j]){
                    j++;
                }
            }
            while(i+1<nums.length && nums[i+1]==nums[i]){
                i++;
            }
        }
        return lst;
    }
}
