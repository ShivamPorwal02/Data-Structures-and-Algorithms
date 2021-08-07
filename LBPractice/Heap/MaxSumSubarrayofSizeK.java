package LoveBabbar.Heap;

import java.util.ArrayList;

public class MaxSumSubarrayofSizeK {
    static int maximumSumSubarray(int k, ArrayList<Integer> arr, int N){
        // code here
        // Queue<Integer> q = new ArrayDeque<>();

        int i = 0;
        int  j = 0;
        int max = Integer.MIN_VALUE;

        int sum = 0;

        while(j<arr.size()){
            if(j-i+1<k){
                sum+=arr.get(j);
                j++;
            }else if(j-i+1==k){
                sum+=arr.get(j);
                max = Math.max(sum,max);
                sum-=arr.get(i);
                i++;
                j++;
            }
        }
        return max;
    }
}
