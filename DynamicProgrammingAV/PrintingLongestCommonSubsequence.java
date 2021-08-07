package DynamicProgrammingAV;

import java.util.Scanner;

public class PrintingLongestCommonSubsequence {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String ans = PrintLCS(s1,s2,s1.length(),s2.length());
        System.out.println(ans);
    }
    public static String PrintLCS(String s1,String s2,int n,int m){
        int[][] lcs = LCS(s1,s2,s1.length(),s2.length());
        int i = n;
        int j = m;
        String ans = "";
        while (i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans =s1.charAt(i-1)+ans;
                i--;
                j--;
            }else{
                if(lcs[i-1][j]>=lcs[i][j-1]){
                    i--;
                }else{
                    j--;
                }
            }
        }
        return ans;
    }
    public static int[][] LCS(String s1,String s2,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for (int i=0;i<n+1 ;i++ ) {
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
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp;
    }
}
