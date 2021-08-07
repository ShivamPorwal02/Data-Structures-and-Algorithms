package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class MatrixChainMultiplication {
    static int[][] dp;
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        dp = new int[101][101];
        for(int[] x : dp){
            Arrays.fill(x,-1);
        }
        int ans = solve(arr,1,N-1);
        return ans;
    }
    static int solve(int[] arr,int i,int j){
        if(i>=j) return 0;
        int min = Integer.MAX_VALUE;

        if(dp[i][j]!=-1) return dp[i][j];

        for(int k=i;k<=j-1;k++){
            int temp = solve(arr,i,k)+solve(arr,k+1,j)+arr[i-1]*arr[j]*arr[k];
            min = Math.min(min,temp);
        }
        return dp[i][j] = min;
    }
}
