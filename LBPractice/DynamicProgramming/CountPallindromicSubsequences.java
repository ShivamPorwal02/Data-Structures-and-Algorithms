package LoveBabbar.DynamicProgramming;

public class CountPallindromicSubsequences {
    public static int count(String s,int n){
        int[][] dp = new int[n][n];
        for(int gap=0;gap<n;gap++){

            for(int i=0,j=gap;j<n;i++,j++){
                if(gap==0){
                    dp[i][j] = 1;
                }else if(gap==1){
                    dp[i][j] = s.charAt(i)==s.charAt(j)?3:2;
                }else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j] = dp[i+1][j] +dp[i][j-1] + 1;
                    }else{
                        dp[i][j] = dp[i+1][j] +dp[i][j-1] - dp[i+1][j-1]; //prefix+suffix-middle
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
