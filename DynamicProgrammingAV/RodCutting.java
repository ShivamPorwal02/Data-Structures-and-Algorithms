package DynamicProgrammingAV;

import java.util.Scanner;

public class RodCutting {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] length = new int[n];
        for (int i=0;i<n ;i++ ) {
            length[i] =scn.nextInt();
        }
        int[] profit = new int[n];
        for (int i=0;i<n ;i++ ) {
            profit[i] = scn.nextInt();
        }
        int rodLength = scn.nextInt();

        int maxProfit = rodCutting(length,profit,n,rodLength);
        System.out.println(maxProfit);
    }
    public static int rodCutting(int[] length,int[] profit,int n,int rodLength){
        int[][] dp = new int[n+1][rodLength+1];
        for (int i=0;i<n+1;i++){
            for (int j=0;j<rodLength+1;j++){
                if(i==0||j==0){
                    dp[i][j]=0;
                }
            }
        }
        for (int i=1;i<n+1;i++) {
            for (int j = 1; j < rodLength + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(profit[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][rodLength];
    }
}
