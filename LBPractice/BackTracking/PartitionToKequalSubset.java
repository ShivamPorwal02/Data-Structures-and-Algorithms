package LoveBabbar.BackTracking;

import java.util.ArrayList;

public class PartitionToKequalSubset {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i = 0 ;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%k!=0) return false;

        int n = nums.length;
        boolean[] isVisited = new boolean[n+1];
        return equalSumPartition(nums,isVisited,0,k,0,sum/k);
    }
    static int cnt;
    public boolean equalSumPartition(int[] nums,boolean[] isVisited,int start,int k,int curr,int subSum){
        if(k==1) return true;
        if(curr>subSum) return false;
        if(curr==subSum) return equalSumPartition(nums,isVisited,0,k-1,0,subSum);

        for(int i=start;i<nums.length;i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            if(equalSumPartition(nums,isVisited,i+1,k,curr+nums[i],subSum)) return true;
            isVisited[i] = false;
        }
        return false;
    }


    public boolean isKPartitionPossible(int nums[], int n, int k)
    {
        // Your code here
        int sum = 0;
        for(int i = 0 ;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%k!=0) return false;

        // int n = nums.length;
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        for(int i=0;i<k;i++){
            lst.add(new ArrayList<>());
        }
        int[] subsetSum = new int[k];

        return equalSumPartition(nums,0,subsetSum,0,lst,k,sum);
    }
    public boolean equalSumPartition(int[] nums,int idx,int[] subsetSum,int nonempty,ArrayList<ArrayList<Integer>> lst,int k,int sum){
        if(idx==nums.length){
            if(nonempty==k){
                boolean flag = true;
                for(int i=0;i<subsetSum.length-1;i++){
                    if(subsetSum[i]!=subsetSum[i+1]){
                        flag = false;
                        break;
                    }
                }
                if(flag==true){
                    return true;
                }
            }
            return false;
        }
        for(int i=0;i<lst.size();i++){
            if(lst.get(i).size()>0){
                lst.get(i).add(nums[idx]);
                subsetSum[i]+=nums[idx];

                if(equalSumPartition(nums,idx+1,subsetSum,nonempty,lst,k,sum)) return true;

                subsetSum[i]-=nums[idx];
                lst.get(i).remove(lst.get(i).size()-1);
            }else{
                lst.get(i).add(nums[idx]);
                subsetSum[i]+=nums[idx];

                if(equalSumPartition(nums,idx+1,subsetSum,nonempty+1,lst,k,sum)) return true;

                subsetSum[i]-=nums[idx];
                lst.get(i).remove(lst.get(i).size()-1);
                break;
            }
        }
        return false;
    }
}
