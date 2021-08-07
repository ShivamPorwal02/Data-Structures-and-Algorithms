package DynamicProgrammingAV;

import java.util.Arrays;
import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] arr){
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        int ans = longestCommonSubsequence(s1,s2,s1.length(),s2.length());
        System.out.println(ans);

        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ansMemo = longestCommonSubsequenceMemorize(s1,s2,s1.length(),s2.length());
        System.out.println(ansMemo);

        int ansTopDown= longestCommonSubsequenceTopDown(s1,s2,s1.length(),s2.length());
        System.out.println(ansTopDown);
    }
    // RECURSIVE
    public static int longestCommonSubsequence(String s1,String s2,int n,int m){
        if(n==0 || m==0){
            return 0;
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return 1+longestCommonSubsequence(s1,s2,n-1,m-1);
        }else{
            return Math.max(longestCommonSubsequence(s1,s2,n,m-1),longestCommonSubsequence(s1,s2,n-1,m));
        }
    }
    //MEMORIZE(BOTTOM UP)
    static int[][] dp = new int[1001][1001];
    public static int longestCommonSubsequenceMemorize(String s1,String s2,int n,int m){
        if(n==0 || m==0){
            return 0;
        }
        if(dp[n][m]!=-1){
            return dp[n][m];
        }
        if(s1.charAt(n-1)==s2.charAt(m-1)){
            return dp[n][m] = 1+longestCommonSubsequenceMemorize(s1,s2,n-1,m-1);
        }else{
            return dp[n][m] = Math.max(longestCommonSubsequenceMemorize(s1,s2,n-1,m),
                    longestCommonSubsequenceMemorize(s1,s2,n,m-1));
        }
    }
    // TOP-DOWN
    public static int longestCommonSubsequenceTopDown(String s1,String s2,int n,int m){
        int[][] dp = new int[n+1][m+1];
        for (int i=0;i<n+1 ;i++ ) {
            for (int j=0;j<m+1 ;j++ ) {
                if(i==0 || j==0){
                    dp[i][j]=0;
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
        return dp[n][m];
    }
}
