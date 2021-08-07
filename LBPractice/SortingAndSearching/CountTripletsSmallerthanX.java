package LoveBabbar.SortingAndSearching;

import java.util.Arrays;

public class CountTripletsSmallerthanX {
    long countTriplets(long arr[], int n,int sum)
    {
        long cnt = 0;
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            int j = i+1;
            int k = arr.length-1;
            while(j<k){
                if(arr[i]+arr[j]+arr[k]>=sum){
                    k--;
                }else{
                    cnt+=(k-j);
                    j++;
                }
            }

        }
        return cnt;
    }
}
