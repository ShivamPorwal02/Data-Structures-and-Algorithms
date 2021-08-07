package LoveBabbar.DynamicProgramming;

public class MaximumSumIncreasingSequence {
    public int maxSumIS(int arr[], int n)
    {
        //code here.
        int[] dp = new int[n+1];
        int omax = 0;
        for(int i=0;i<arr.length;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    if(dp[j]>max) max = dp[j];
                }
            }
            dp[i] = arr[i]+max;
            if(dp[i] > omax) omax = dp[i];
        }
        return omax;
    }
}
