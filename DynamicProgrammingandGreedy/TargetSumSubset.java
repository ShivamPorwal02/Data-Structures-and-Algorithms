package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n ;i++ ) {
            a[i]=scn.nextInt();
        }
        int target = scn.nextInt();

        // agr khaali hai array aur sum 0 chhahia to hm de kste hai by giving the empty subset {} .
        boolean[][] dp = new boolean[n+1][target+1];
        for (int j=0;j<dp[0].length ;j++ ) {
            dp[0][j] = false;
        }
        for (int i=0;i<dp.length ;i++ ) {
            dp[i][0]=true;
        }
        for (int i=1;i<dp.length ;i++ ) {
            for (int j=1;j<dp[0].length ;j++ ) {
                if(a[i-1]<=j){
                    dp[i][j] = dp[i-1][j-a[i-1]] || dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][target]);
    }
}
