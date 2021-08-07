package LoveBabbar.DynamicProgramming;

public class MinimumDeletiontoFormAPallindrome {
    static int countMin(String str)
    {
        // code here
        return str.length()-LPS(str);
    }

    static int LPS(String s){
        String rev = "";
        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        int lcs = LCS(s,rev);
        return lcs;
    }
    static int LCS(String s1,String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                if(i==0 || j==0) dp[i][j] = 0;
            }
        }

        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
