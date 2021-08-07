package LoveBabbar.Graph;

public class FloydWarshall_GFG {
    public void shortest_distance(int[][] dp)
    {
        // Code here
        int n = dp.length;

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dp[i][k]!=-1 && dp[k][j]!=-1)
                    {
                        if(dp[i][j]==-1 || dp[i][k]+dp[k][j]<dp[i][j])
                        {
                            dp[i][j]= dp[i][k]+dp[k][j];
                        }
                        //   dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j]);
                    }
                }
            }
        }
    }
}
