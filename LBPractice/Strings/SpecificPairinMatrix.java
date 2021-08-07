package LoveBabbar.Strings;

import java.util.Scanner;

public class SpecificPairinMatrix {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] arr = new int[n][n];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<n ;j++ ) {
                arr[i][j] = scn.nextInt();
            }
        }
        int ans = specificPair(arr,n);
        System.out.println(ans);
    }
    public static int specificPair(int[][] arr,int n){
        int[][] dp = new int[n][n];
        int max = 0;
        for(int j=0;j<arr[0].length;j++){
            dp[0][j] = arr[0][j];
        }
        for(int i=0;i<arr.length;i++){
            dp[i][0] = arr[i][0];
        }
        for(int i=1;i<n;i++){
            for (int j=1;j<n ;j++ ) {
                dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),Math.min(arr[i][j],dp[i-1][j-1]));
                if(arr[i][j]-dp[i-1][j-1]>max){
                    max = arr[i][j]-dp[i-1][j-1];
                }
            }
        }
        return max;
    }
}
