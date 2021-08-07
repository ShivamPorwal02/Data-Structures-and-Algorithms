package LoveBabbar.DynamicProgramming;

public class LongestCommonSubstring {
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // code here
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int max = 0;
        for(int i=0;i<s1.length()+1;i++){
            for(int j=0;j<s2.length()+1;j++){
                if(i==0 || j==0 ){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1;i<s1.length()+1;i++){
            for(int j=1;j<s2.length()+1;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(dp[i][j]>max) max = dp[i][j];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
