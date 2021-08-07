package LoveBabbar.DynamicProgramming;

public class LargestSquareFormedinMatrix {
    static int maxSquare(int n, int m, int matrix[][]){
        // code here
        int[][] dp = new int[matrix.length][matrix[0].length];

        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(i==0 || j==0){
                    dp[i][j] = matrix[i][j];
                    if(dp[i][j]>max) max = dp[i][j];
                }
                else if(matrix[i][j]==0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    if(dp[i][j]>max) max = dp[i][j];
                }
            }
        }
        return max;
    }
}
