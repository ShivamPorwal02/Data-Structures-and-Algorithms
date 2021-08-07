package LoveBabbar.SortingAndSearching;

import java.util.Scanner;

public class RastaAndKhestak_BiggestCommonSubsquare {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] a = new int[n][m];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                a[i][j] = scn.nextInt();
            }
        }
        int x = scn.nextInt();
        int y = scn.nextInt();
        int[][] b = new int[x][y];
        for (int i=0;i<n ;i++ ) {
            for (int j=0;j<m ;j++ ) {
                b[i][j] = scn.nextInt();
            }
        }
        int ans = BCS(a);
        System.out.println(ans);
        int ans2 = BCS(b);
        System.out.println(ans2);
    }
    public static int BCS(int[][] arr){
        int[][] dp = new int[arr.length][arr[0].length];
        int max= 0;
        for (int i=0;i<arr.length ;i++ ) {
            for(int j=0;j<arr[0].length;j++){
                if(i==0 || j==0){
                    if(arr[i][j] == 0 ){
                        dp[i][j] =  0;
                    }else{
                        dp[i][j] = 1;
                    }
                }else{
                    if(arr[i][j] == 0){
                        dp[i][j] = 0;
                    }else{
                        dp[i][j] = 1+ Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    }
                }
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
