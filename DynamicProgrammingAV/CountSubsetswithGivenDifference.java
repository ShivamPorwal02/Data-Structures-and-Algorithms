package DynamicProgrammingAV;

import java.util.Scanner;

public class CountSubsetswithGivenDifference {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int diff = scn.nextInt();
        int ans = subsetswithGivenDiff(arr,n,diff);
        System.out.println(ans);
    }
    public static int subsetswithGivenDiff(int[] arr,int n,int diff){
        int sum=0;
        for (int i =0 ;i<n ;i++ ) {
            sum+=arr[i];
        }
        int rqd = (sum+diff)/2;
        return subsetsWithGivenSum(arr,rqd,n);
    }
    public static int subsetsWithGivenSum(int[] arr,int rqd,int n){
        int[][] dp = new int[n+1][rqd+1];

        for (int i=0;i<n+1 ;i++ ) {
            dp[i][0] =1;
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
