package LevelUp.DynamicProgramming;

import java.util.Scanner;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int[] dp = new int[n];
        int omax = 0;
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[i]>=arr[j]){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+arr[i];
            if(dp[i]>omax){
                omax = dp[i];
            }
        }
        System.out.println(omax);
    }
}
