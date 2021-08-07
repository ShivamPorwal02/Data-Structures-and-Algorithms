package DynamicProgrammingAV;

import java.util.Scanner;

public class TargetSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        int ans = targetSum(arr,n,sum);
        System.out.println(ans);
    }
    public static int targetSum(int[] arr,int n,int sum){

        // iska sahi version dp love babbar m hai
        int asum =0;
        for (int i=0;i<n ;i++ ) {
            asum+=arr[i];
        }
        int rqd = (asum+sum)/2;
        return subsetswithGivenSum(arr,n,rqd);
    }
    public static int subsetswithGivenSum(int[] arr,int n,int rqd){
        int[][] dp = new int[n+1][rqd+1];
        for (int i=0;i<n+1 ;i++ ) {
            dp[i][0] = 1;
        }
        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<rqd+1 ;j++ ) {
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][rqd];
    }
}
