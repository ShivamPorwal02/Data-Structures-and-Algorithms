package DynamicProgrammingAV;

import java.util.Scanner;

public class CountofSubsetswithGivenSum {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        int ans = countofSubsetswithgivenSum(arr,sum,n);
        System.out.println(ans);
    }
    public static int countofSubsetswithgivenSum(int[] arr,int sum,int n){
        int[][] dp = new int[n+1][sum+1];

        for(int i=0;i<n+1;i++){
            dp[i][0] = 1;
        }
        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<sum+1 ;j++ ) {
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]]+dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
