package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class MinCostMazeTraversal {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                a[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                if(i>=1 && j>=1){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+a[i][j];
                }
                else if(i==0 && j>0){
                    dp[i][j] = a[i][j]+dp[i][j-1];
                }
                else if(j==0 && i>0){
                    dp[i][j] = a[i][j]+dp[i-1][j];
                }
                else{
                    dp[i][j] = a[i][j];
                }
            }
        }
        for (int i =0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(dp[n-1][m-1]);
        int[][] x = new int[n][m];
        MinPath(a,x,n,m);
    }
    public static void MinPath(int[][] a,int[][] dp,int n,int m){
        // inhone last wale se ulta kia hai
        for (int i=dp.length-1;i>=0 ;i-- ) {
            for (int j=dp[0].length-1;j>=0 ;j-- ) {
                if(i==dp.length-1 && j==dp[0].length-1 ){
                    dp[i][j] = a[i][j];
                }
                else if(i== dp.length-1){
                    dp[i][j]=dp[i][j+1] +a[i][j];
                }
                else if(j==dp[0].length-1){
                    dp[i][j] = dp[i+1][j]+a[i][j];
                }
                else{
                    dp[i][j] = Math.min(dp[i+1][j],dp[i][j+1])+a[i][j];
                }
            }
        }
        System.out.println(dp[0][0]);
    }
}
