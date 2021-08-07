package DynamicProgrammingAV;

import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] wt = new int[n];
        for (int i=0;i<n ;i++ ) {
            wt[i] = scn.nextInt();
        }
        int[] val = new int[n];
        for (int i=0;i<n ;i++ ) {
            val[i] = scn.nextInt();
        }
        int w = scn.nextInt();
        int profit = unboundedKnapsack(wt,val,n,w);
    }
    public static int unboundedKnapsack(int[] wt,int[] val,int n,int w){
        int[][] dp = new int[n+1][w+1];

        for (int i=0;i<n+1 ;i++ ) {
            for (int j=0;j<w+1 ;j++ ) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<w+1 ;j++ ) {
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
