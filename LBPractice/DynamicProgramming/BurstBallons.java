package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class BurstBallons {
    int[][] dp;
    public int maxCoins(int[] nums) {
        dp = new int[502][502];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        int[] arr = new int[nums.length+2];
        for(int i=0;i<nums.length;i++){
            arr[i+1] = nums[i];
        }
        arr[0] = 1;
        arr[nums.length+1] = 1;

        int ans = solve(arr,1,arr.length-1);
        return ans;
    }

    int solve(int[] arr,int i,int j){
        if(i>=j) return 0;

        int max = Integer.MIN_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        for(int k=i;k<=j-1;k++){
            int temp = solve(arr,i,k)+solve(arr,k+1,j)+ arr[i-1]*arr[j]*arr[k];
            max = Math.max(max,temp);
        }
        return dp[i][j] = max;
    }
}
