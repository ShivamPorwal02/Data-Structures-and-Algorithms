package LoveBabbar.Greedy;

import java.util.Arrays;

public class MaximumSumofConsecutiveElementsinCircularArray {
    long maxSum(long arr[] ,int n)
    {

        Arrays.sort(arr);
        long[] arr2 = new long[n];
        int i = 0;
        int j=arr.length-1;

        int k = 0;
        while(i<j){
            arr2[k] = arr[i];
            k++;
            arr2[k] = arr[j];
            k++;
            i++;
            j--;
        }
        if(i==j) arr2[k] = arr[i];

        long ans = 0;
        for(i=0;i<arr2.length;i++){
            ans+=(Math.abs(arr2[i]-(i==arr2.length-1 ? arr2[0] : arr2[i+1])));
        }
        return ans;
    }
}
