package DynamicProgrammingAV;

import java.util.Scanner;

public class LongestCommonSubstring {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        int ans = longestCommonSubstring(s1,s2,s1.length(),s2.length());
        System.out.println(ans);
    }
    public static int longestCommonSubstring(String s1,String s2,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for (int i=0;i<n+1;i++){
            for (int j=0;j<m+1 ;j++ ) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for (int i=1;i<n+1 ;i++ ) {
            for (int j=1;j<m+1 ;j++ ) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n+1 ;i++ ) {
            for (int j=0;j<m+1 ;j++ ) {
                if(max<dp[i][j]){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
}
