package DynamicProgrammingAV;

import java.util.Scanner;

public class MinNoofInsertionandDeletiontoConvertStringAtoB {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        MinInsertionDeletonAtoB(s1,s2,s1.length(),s2.length());
    }
    public static void MinInsertionDeletonAtoB(String s1,String s2,int n,int m){
        int lcs = LCS(s1,s2,n,m);
        int deletion = s1.length()-lcs;
        int insertion = s2.length()-lcs;
        System.out.println("Insertion "+insertion+" "+"Deletion "+deletion);

    }
    public static int LCS(String s1,String s2, int n,int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i=0;i<n+1 ;i++ ) {
            for (int j=0;j<m+1 ;j++ ) {
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
