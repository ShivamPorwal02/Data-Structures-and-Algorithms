package LoveBabbar.DynamicProgramming;

import java.util.HashMap;

public class LargestSubarraywith0sum {
    int maxLen(int arr[], int n)
    {
        // Your code here
        HashMap<Integer,Integer> hm = new HashMap<>();

        int sum = 0;
        int maxL = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                // System.out.println(i);
                // System.out.println(hm.get(arr[i])+"sh");
                if(i-hm.get(sum)>maxL) maxL = i-hm.get(sum);
            }
            else if(sum==0) maxL = Math.max(maxL,i+1);
            else hm.put(sum,i);
            // System.out.println(hm);

        }
        return maxL;
    }
}
