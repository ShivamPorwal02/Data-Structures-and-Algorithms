package LoveBabbar.DynamicProgramming;

import java.util.ArrayList;

public class MinimumSumPartition {
    boolean[][] dp;
    public int minDiffernce(int arr[], int n)
    {
        // Your code goes here
        int sum = 0 ;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        boolean[][] ans = subsetSum(arr,sum,n);

        ArrayList<Integer> lst = new ArrayList<>();
        for(int j=0;j<(sum+2)/2;j++){
            if(dp[n][j]==true) lst.add(j);
        }
        // System.out.println(lst);
        int min = Integer.MAX_VALUE;
        for(int val : lst){
            if(min>sum-2*val) min = sum-2*val;
        }
        return min;
    }

    public boolean[][] subsetSum(int[] arr,int sum,int n){
        dp = new boolean[n+1][sum+1];
        for (int j=0;j<sum+1 ;j++ ) {
            dp[0][j] = false;
        }
        for (int i=0;i<n+1 ;i++ ) {
            dp[i][0] = true;
        }
        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<sum+1 ;j++ ) {
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp;
    }
}
