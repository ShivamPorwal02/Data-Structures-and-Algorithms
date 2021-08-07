package LoveBabbar.DynamicProgramming;

public class CountBalancedBinaryTreeofHeightH {
    static long countBT(int h){
        // code here;
        int MOD = 1000000007;
        long[] dp = new long[h+1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=h;i++){
            dp[i] = dp[i-1]*(2*(dp[i-2])+dp[i-1]);
            dp[i] = (dp[i]<0 ? dp[i]+MOD : dp[i])%MOD;
        }
        return dp[h];
    }
}
