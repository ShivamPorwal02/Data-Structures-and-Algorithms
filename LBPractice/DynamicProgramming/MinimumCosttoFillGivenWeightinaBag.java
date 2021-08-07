package LoveBabbar.DynamicProgramming;

public class MinimumCosttoFillGivenWeightinaBag {
    public int minimumCost(int cost[], int n,int w)
    {
        // Your code goes here
        int[] wt = new int[n];
        for(int i=0;i<n;i++){
            wt[i] = i+1;

        }

        int[][] dp = new int[cost.length+1][w+1];

        for(int j=1;j<w+1;j++) dp[0][j] = Integer.MAX_VALUE;

        for(int i=1;i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(wt[i-1]<=j && cost[i-1]!=-1){
                    if(dp[i][j-wt[i-1]]!=Integer.MAX_VALUE){
                        dp[i][j] = Math.min(cost[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                    }else dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w]==Integer.MAX_VALUE ? -1 : dp[n][w];
    }
}
