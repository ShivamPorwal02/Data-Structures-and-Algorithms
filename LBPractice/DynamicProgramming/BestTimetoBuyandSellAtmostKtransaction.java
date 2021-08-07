package LoveBabbar.DynamicProgramming;

public class BestTimetoBuyandSellAtmostKtransaction {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0) return 0;
        int n = prices.length;
        int[][] dp = new int[k+1][n];

        for(int i=1;i<k+1;i++){
            int max = Integer.MIN_VALUE;
            for(int j=1;j<n;j++){
                max = Math.max(max,dp[i-1][j-1]-prices[j-1]);

                dp[i][j] = Math.max(dp[i][j-1],max+prices[j]);
            }
        }
        return dp[k][n-1];
    }
}
