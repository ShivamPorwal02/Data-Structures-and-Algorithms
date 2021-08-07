package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class Goldmine {
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
        for (int col=0;col<m ;col++ ) {
            for (int i=0;i<n ;i++ ) {
                if(col==0){
                    dp[i][col] = a[i][col];
                }
                else if(i==0){
                    dp[i][col] = Math.max(dp[i][col-1],dp[i+1][col-1])+a[i][col];
                }
                else if(i==n-1){
                    dp[i][col] = Math.max(dp[i][col-1],dp[i-1][col-1])+a[i][col];
                }
                else{
                    dp[i][col] = Math.max(Math.max(dp[i][col-1],dp[i+1][col-1]),dp[i-1][col-1])+a[i][col];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i =0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                if(dp[i][j]>max){
                    max = dp[i][j];
                }
            }
        }
        // ye upr waale ko kevl last column m bhi lga skte ho
        System.out.println(max);

        // Issm bhi sir ki approach ulti hai last column ko phle bhra hai baad m dusra

    }
}
