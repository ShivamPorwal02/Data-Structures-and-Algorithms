package LoveBabbar.DynamicProgramming;

public class GoldMineProblem {
    static int maxGold(int n, int m, int M[][])
    {
        // code here

        int[][] dp = new int[n][m];


        int omax = 0;

        for(int i=0;i<n;i++){
            dp[i][0] = M[i][0];
            if(dp[i][0]>omax) omax = dp[i][0];
        }


        for(int j=1;j<m;j++){
            for(int i=0;i<n;i++){
                if(i==0){
                    dp[i][j] = M[i][j] + Math.max(dp[i][j-1],i==n-1 ? 0 : dp[i+1][j-1]);
                    if(dp[i][j]>omax) omax = dp[i][j];
                }else if(i==n-1 ){
                    dp[i][j] = M[i][j] + Math.max(dp[i][j-1],i==0 ? 0 : dp[i-1][j-1]);
                    if(dp[i][j]>omax) omax = dp[i][j];
                }else{
                    dp[i][j] = M[i][j] + Math.max(Math.max(dp[i][j-1],i==0 ? 0 : dp[i-1][j-1]),i==n-1 ? 0 : dp[i+1][j-1]);
                    if(dp[i][j]>omax) omax = dp[i][j];
                }
            }
        }
        return omax;
    }
}
