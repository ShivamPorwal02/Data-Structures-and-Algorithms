package DynamicProgrammingAV;

import java.util.Scanner;

public class CoinChange1MaxNumberofWays {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for (int i=0;i<n ;i++ ) {
            coins[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        int maxWays = CoinChange(coins,n,sum);
        System.out.println(maxWays);
    }
    public static int CoinChange(int[] coin,int n,int sum){
        int[][] dp = new int[n+1][sum+1];
        for (int i=0;i<n+1 ;i++ ) {
            dp[i][0] = 1;
        }

        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<sum+1 ;j++ ) {
                if(coin[i-1]<=j){
                    dp[i][j] = dp[i][j-coin[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
