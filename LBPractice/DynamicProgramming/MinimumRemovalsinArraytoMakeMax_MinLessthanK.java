package LoveBabbar.DynamicProgramming;

import java.util.Arrays;

public class MinimumRemovalsinArraytoMakeMax_MinLessthanK {
    static int[][] dp;
    public static int countRemovals(int[] arr,int i,int j,int k){
        if(i>=j) return 0;
        if(arr[j]-arr[i]<=k) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        else if(arr[j]-arr[i]>k){
            dp[i][j] = 1 + Math.min(countRemovals(arr,i+1,j,k),countRemovals(arr,i,j-1,k));
        }
        return dp[i][j];
    }
    static int removals(int a[], int n, int k)
    {
        // sort the array
        Arrays.sort(a);

        // fill all stated with -1
        // when only one element
        for(int[] rows:dp)
            Arrays.fill(rows,-1);
        if (n == 1)
            return 0;
        else
            return countRemovals(a, 0, n - 1, k);
    }
}
