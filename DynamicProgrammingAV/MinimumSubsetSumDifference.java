package DynamicProgrammingAV;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimumSubsetSumDifference {
    public static void main(String[] ar){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n ;i++ ) {
            arr[i] = scn.nextInt();
        }
        int ans = minimumSubsetSum(arr,n);
        System.out.println(ans);
    }
    public static int minimumSubsetSum(int[] arr,int n){
        int sum=0;
        for (int i=0;i<n ;i++ ) {
            sum+=arr[i];
        }
        boolean dp[][] = subsetSum(arr,n,sum);
        ArrayList<Integer> lst = new ArrayList<>();
        for (int j=0;j<(sum+2)/2 ;j++ ) {
            if(dp[n][j]==true) {
                lst.add(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int val : lst ) {
            if(min>(sum-2*val)){
                min = sum-2*val;
            }
        }
        return min;
    }
    public static boolean[][] subsetSum(int[] arr,int n,int sum){
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int j=0;j<sum+1 ;j++ ) {
            dp[0][j] = false;
        }
        for (int i=0;i<n+1 ;i++ ) {
            dp[i][0] = true;
        }
        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<sum+1 ;j++ ) {
                if(arr[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-arr[i-1]] || dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp;
    }
}
