package Revision;

public class DominoandTrominoTiling {
    static int mod = (int)Math.pow(10,9)+7;
    public int numTilings(int n) {
        if(n==1 || n==2) return n;
        long[] dp = new long[n+1];
        dp[0] = 1; // kisis cheez ko na tile krne ka ek tareeka
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for(int i=4;i<=n;i++){
            dp[i] = 2*dp[i-1]+dp[i-3];
            dp[i] = (dp[i])%mod;
        }
        return (int)dp[n];
    }
}
