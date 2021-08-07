package LoveBabbar.DynamicProgramming;

public class MaximumPathSuminMatrix {
    static int maximumPath(int n, int mat[][])
    {
        // code here
        if(mat.length==1) return mat[0][0];
        int[][] dp = new int[n][n];
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==0){
                    dp[i][j] = mat[i][j];
                }else if(j==0){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j+1])+mat[i][j];
                    if(dp[i][j]>max) max = dp[i][j];
                }else if(j==n-1){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1])+mat[i][j];
                    if(dp[i][j]>max) max = dp[i][j];
                }else{
                    dp[i][j] = Math.max(Math.max(dp[i-1][j],dp[i-1][j-1]),dp[i-1][j+1])+mat[i][j];
                    if(dp[i][j]>max) max = dp[i][j];
                }
            }
        }
        return max;
    }
}
