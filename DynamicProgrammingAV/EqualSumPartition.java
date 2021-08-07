package DynamicProgrammingAV;

import java.util.Scanner;

public class EqualSumPartition {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        boolean ans = equalSumPartition(arr,n);
        System.out.println(ans);
    }
    public static boolean equalSumPartition(int[] arr,int n){
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=arr[i];
        }
        if(sum%2!=0) {
            return false;
        }else{
            int halfsum = sum/2;
            return SubsetSum(arr,halfsum,n);
        }
    }
    public static boolean SubsetSum(int[] arr,int sum,int n){
        boolean[][] dp = new boolean[n+1][sum+1];

        for (int j=0;j<sum+1 ;j++ ) {
            dp[0][j]= false;
        }
        for (int i=0;i<n+1 ;i++ ) {
            dp[i][0]= true;
        }
        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<sum+1 ;j++ ) {
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
