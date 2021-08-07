package LevelUp.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {
    static int[][] dp = new int[11][11];
    public static int LCS(String s1,String s2,int n,int m){
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) throws Exception {
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        int ans = LCS(s1,s2,s1.length(),s2.length());
        System.out.println(ans);
    }
}
