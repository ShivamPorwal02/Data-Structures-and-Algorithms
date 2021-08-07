package LoveBabbar.DynamicProgramming;

public class FriendsPairingProblem {
    public long countFriendsPairings(int n)
    {
        //code here
        int mod = (int)Math.pow(10,9)+7;
        long[] dp = new long[n+1];
        if(n==1 || n==2) return n;
        //   dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2 ;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+(i-1)*dp[i-2];
            dp[i] = (dp[i]<0 ? dp[i]+mod : dp[i])%mod;
        }
        return dp[n];
    }
}
