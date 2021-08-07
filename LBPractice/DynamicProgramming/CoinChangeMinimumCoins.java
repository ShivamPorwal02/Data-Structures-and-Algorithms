package LoveBabbar.DynamicProgramming;

public class CoinChangeMinimumCoins {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        if(coins.length==1){
            return amount%coins[0]!=0 ? -1 : amount/coins[0];
        }
        if(amount==0) return -1;
        int[][] dp = new int[coins.length+1][amount+1];

        for(int j=0;j<amount+1;j++){
            dp[0][j] = Integer.MAX_VALUE-1;
        }
        // agr hm ye niche wala step na bhi krre to aur i=1 se looop chlae niche tbh bhi hora hai leetcode m
        for(int j=1;j<amount+1;j++){
            if(j%coins[0]==0){
                dp[1][j] = j/coins[0];
            }else{
                dp[1][j] = Integer.MAX_VALUE-1;
            }
        }
        for(int i=2;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[coins.length][amount]==Integer.MAX_VALUE-1 ? -1 : dp[coins.length][amount];
    }
}
