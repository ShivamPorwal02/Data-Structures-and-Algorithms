package DynamicProgrammingAV;

import java.util.Scanner;

public class CoinChangeMinNumberofCoins {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for (int i=0;i<n ;i++ ) {
            coins[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        int minCoins = MinCoinChange(coins,n,sum);
        System.out.println(minCoins);
    }
    public static int MinCoinChange(int[] coins,int n,int sum){
        int[][] dp = new int[n+1][sum+1];
        for (int i=0;i<n+1 ;i++ ) {
            dp[i][0] = 0;
        }
        for (int j=0;j<sum+1 ;j++ ) {
            dp[0][j] = Integer.MAX_VALUE-1;
        }
        for (int j=1;j<sum+1 ;j++ ) {
            if(j%coins[0]==0){
                dp[1][j] = j/coins[0];
            }else{
                dp[1][j] = Integer.MAX_VALUE-1;
            }
        }
        for (int i=2;i<n+1 ;i++ ) {
            for (int j=1;j<sum+1 ;j++ ) {
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
