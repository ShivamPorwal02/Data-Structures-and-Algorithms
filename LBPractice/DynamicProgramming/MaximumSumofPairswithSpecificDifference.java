package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class MaximumSumofPairswithSpecificDifference {
    public static int maxSumPairWithDifferenceLessThanK(int arr[], int n, int K)
    {
        // Your code goes here
        Arrays.sort(arr);
        int[] dp = new int[n];

        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]<K){
                if(i>=2) dp[i] = Math.max(dp[i-1],dp[i-2]+arr[i]+arr[i-1]);
                else dp[i] = Math.max(dp[i-1],arr[i]+arr[i-1]);
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }
}
