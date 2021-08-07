package LoveBabbar.DynamicProgramming;

import java.util.Scanner;

public class MaximumSumSuchthatNoThreeAreConsecutive {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }

        int[] dp = new int[n];

        dp[0] = arr[0];
        // assuming all elements are positive
        dp[1] = arr[0]+arr[1];

        dp[2] = Math.max(dp[1],Math.max(arr[0]+arr[2],arr[1]+arr[2]));

        for(int i=3;i<n;i++){
            dp[i] = Math.max(dp[i-1],Math.max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]));
        }
        System.out.println(dp[n-1]);
    }
}
