package LoveBabbar.SortingAndSearching;

import java.util.HashMap;

public class CountofZeroSumSubArray {
    public static long findSubarray(long[] arr ,int n)
    {
        //Your code here
        HashMap<Long,Integer> hm = new HashMap<>();
        long sum = 0;
        int cnt = 0;
        int i = -1;
        hm.put((long)0,1);
        while(i<arr.length-1){
            i++;
            sum+=arr[i];
            if(hm.containsKey(sum)){
                cnt+=hm.get(sum);
                hm.put(sum,hm.get(sum)+1);
            }else{
                hm.put(sum,1);
            }
        }
        return cnt;
    }
}
