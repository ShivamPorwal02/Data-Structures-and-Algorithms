package MayChallenge;

public class May12_RangeSumQuery2D_Immutable {

    // kaafi bdia hai concept use krna

//    https://youtu.be/hAyme0s2DOY (soln)

    private int[][] dp;
    public May12_RangeSumQuery2D_Immutable(int[][] matrix) {
        if(matrix==null || matrix[0].length==0 || matrix.length==0){
            return ;
        }

        dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1] + matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}
