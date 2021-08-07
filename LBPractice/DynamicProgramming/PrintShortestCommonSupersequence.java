package LoveBabbar.DynamicProgramming;

public class PrintShortestCommonSupersequence {
    public static void main(String[] args) {
        String s1 = "abbaaa";
        String s2 = "abbaba";

        int[][] ans = LCS(s1, s2);

        int i = s1.length();
        int j = s2.length();

        String res = "";
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                res = s1.charAt(i - 1) + res;
                i--;
                j--;
            } else {
                if (ans[i - 1][j] >= ans[i][j - 1]) {
                    res = s1.charAt(i - 1) + res;
                    i--;
                } else {
                    res = s2.charAt(j - 1) + res;
                    j--;
                }
            }
            while(i>0){
                res=s1.charAt(i-1)+res;
                i--;
            }
            while(j>0){
                res=s2.charAt(j-1)+res;
                j--;
            }
        }
    }

    public static int[][] LCS(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
            }
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }
}
