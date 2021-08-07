package DynamicProgrammingandGreedy;

import java.util.Scanner;

public class UnboundedKnapsack {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] items = new int[n];
        for (int i=0;i<n ;i++ ) {
            items[i] = scn.nextInt();
        }
        int[] wt = new int[n];
        for (int i=0;i<n ;i++ ) {
            wt[i] = scn.nextInt();
        }
        int sackwt = scn.nextInt();
        int[][] dp = new int[n+1][sackwt+1];
        for (int i=0;i<dp.length ;i++) {
            for (int j=0;j<dp[0].length ;j++ ) {
                if(i==0 || j==0){
                    dp[i][j]=0;
                }
            }
        }
        // sbb same hai bss i-1 ko i kia hai kyuki hm ek element ko kitne baar bi access krr skta hai
        //recursive m n ko n-1 ni krrge usko hmne waha i se relate krr rkha tha to yabha ahmne i ko i-1 ni kia.
        for (int i=1;i<dp.length ;i++ ) {
            for (int j=1;j<dp[0].length ;j++ ) {
                if(wt[i-1]<=j){
                    dp[i][j] = Math.max((items[i-1]+dp[i][j-wt[i-1]]),dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][sackwt]);
    }
}
