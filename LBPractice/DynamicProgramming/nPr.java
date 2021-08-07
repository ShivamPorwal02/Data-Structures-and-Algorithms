package LoveBabbar.DynamicProgramming;

import java.util.Scanner;

public class nPr {
    public static int Permutation(int n,int r){
        int[][] dp = new int[r+1][n+1];

        for(int i=0;i<r+1;i++){
            for (int j=0;j<n+1 ;j++ ) {
                if(i==0){
                    dp[i][j] = 1;
                }else if(i==1 && j==1) dp[i][j] = 1;
                else if(i>j){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i][j-1] + i*dp[i-1][j-1];
                }
            }
        }
        return dp[r][n];
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int ans = Permutation(n,r);

        // O(N) m factorial nikal lo n!/(n-k)!
        System.out.println(ans);
    }
}
