package LoveBabbar.DynamicProgramming;

public class InterleavingStrings {
    // Recursive
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        return isInterleaved(s1,s2,s3,0,0,0);
    }
    public boolean isInterleaved(String s1,String s2,String s3,int i,int j,int x){
        if(i==s1.length() && j==s2.length() && x == s3.length()) return true;

        if(x==s3.length()) return false;

        return (i<s1.length() && s1.charAt(i)==s3.charAt(x) && isInterleaved(s1,s2,s3,i+1,j,x+1)) ||
                (j<s2.length() &&  s2.charAt(j)==s3.charAt(x) && isInterleaved(s1,s2,s3,i,j+1,x+1));
    }


    // DP

    public boolean isInterleave_(String s1, String s2, String s3) {
        boolean dp[][] = new boolean[s1.length() +1][s2.length() +1];

        if(s1.length() + s2.length() != s3.length()){
            return false;
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                int l = i+j-1;

                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                else if(i==0){
                    if(s2.charAt(j-1)==s3.charAt(l)) dp[i][j] = dp[i][j-1];
                    else dp[i][j] = false;
                }else if(j==0){
                    if(s1.charAt(i-1)==s3.charAt(l)) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = false;
                }else{
                    dp[i][j] = (s1.charAt(i-1)==s3.charAt(l) ? dp[i-1][j] : false) ||
                            (s2.charAt(j-1)==s3.charAt(l) ? dp[i][j-1] : false);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

}
