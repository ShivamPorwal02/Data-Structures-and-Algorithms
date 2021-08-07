package LevelUp.DynamicProgramming;

import java.util.Scanner;

public class LongestBitonicSubsequence {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = scn.nextInt();
        }
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            int max = 0;
            for(int j=0;j<i;j++){
                if(arr[i]>=arr[j]){
                    if(dp[j]>max){
                        max = dp[j];
                    }
                }
            }
            dp[i] = max+1;
        }

        int[] dp1 = new int[n];
        for(int i=n-1;i>=0;i--){
            int max = 0;
            for(int j=n-1;j>i;j--){
                if(arr[i]>=arr[j]){
                    if(dp1[j]>max){
                        max = dp1[j];
                    }
                }
            }
            dp1[i] = max+1;
        }
        int msum=0;
        for(int i=0;i<n;i++){
            if(dp[i]+dp1[i]-1>msum){
                msum = dp[i]+dp1[i]-1;
            }
        }
        System.out.println(msum);
    }
}
