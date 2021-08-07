package DynamicProgrammingAV;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Zero_One_Knapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for (int i=0;i<n ;i++ ) {
            val[i]=scn.nextInt();
        }
        for (int i=0;i<n ;i++ ) {
            wt[i] = scn.nextInt();
        }
        int totalwt = scn.nextInt();
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        int x = maxProfit(wt,val,totalwt,n);
        System.out.println(x);
        int y = maxProfit2(wt,val,totalwt,n);
        System.out.println(y);
    }
    // recursive
    public static int maxProfit3(int[] wt,int[] val,int totalwt,int n){
        if(n==0 || totalwt == 0){
            return 0;
        }
        if(wt[n-1]<=totalwt){
            return Math.max(val[n-1]+maxProfit(wt,val,totalwt-wt[n-1],n-1),maxProfit(wt,val,totalwt,n-1));
        }
        else{
            return maxProfit(wt,val,totalwt,n-1);
        }
    }
    // memorization
    static int[][] dp = new int[21][51];
    public static int maxProfit(int[] wt,int[] val,int w,int n){
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w]!=-1){
            return dp[n][w];
        }
        if(wt[n-1]<=w){
            return dp[n][w] = Math.max(val[n-1]+maxProfit(wt,val,w-wt[n-1],n-1),
                                   maxProfit(wt,val,w,n-1));
        }
        else{
            return dp[n][w] = maxProfit(wt,val,w,n-1);
         }
    }
    // bottom up

    public static int maxProfit2(int[] wt,int[] val,int w,int n){
        int[][] dp = new int[n+1][w+1];

        for(int i=0;i<n+1;i++) {
            for (int j = 0; j < w + 1; j++) {
                if (i == j) {
                    dp[i][j] = 0;
                }
            }
        }
            for (int i=1;i<n+1;i++ ) {
                for (int j=1;j<w+1 ;j++ ) {
                    if(wt[i-1]<=j){
                        dp[i][j] = Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }
            return dp[n][w];
        }
    }
