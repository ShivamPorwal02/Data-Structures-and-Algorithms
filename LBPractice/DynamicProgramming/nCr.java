package LoveBabbar.DynamicProgramming;

public class nCr {
    static int nCr(int n, int r) {
        // code here
        long[][] dp = new long[r + 1][n + 1];

        int mod = (int) Math.pow(10, 9) + 7;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || i == j) {
                    dp[i][j] = 1;
                } else if (i > j) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                }
                dp[i][j] = (dp[i][j] < 0 ? dp[i][j] + mod : dp[i][j]) % mod;
            }
        }
        // for(int[] x : dp){
        //     System.out.println(Arrays.toString(x));
        // }
        return (int) dp[r][n];
    }
}
